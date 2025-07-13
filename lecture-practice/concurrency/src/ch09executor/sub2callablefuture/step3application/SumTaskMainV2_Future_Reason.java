package ch09executor.sub2callablefuture.step3application;

import java.util.concurrent.*;

import static util.MyLogger.log;

public class SumTaskMainV2_Future_Reason {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        SumTask sumTask1 = new SumTask(1, 50);
        SumTask sumTask2 = new SumTask(51, 100);

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = es.submit(sumTask1);
        Future<Integer> future2 = es.submit(sumTask2);

        Integer sum1 = future1.get(); // Blocking - 약 2초 대기
        Integer sum2 = future2.get(); // Blocking - 거의 즉시 반환

        log("task1.result = " + sum1);
        log("task2.result = " + sum2);

        int sumAll = sum1 + sum2;
        log("task1 + task2 = " + sumAll);
        log("End");

        es.close();
    }

    static class SumTask implements Callable<Integer> {

        int startValue;
        int endValue;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public Integer call() throws Exception {

            log("작업 시작");
            Thread.sleep(2000); // Runnable run()은 InterruptedException 을 내부에서 직접 처리했어야했다.

            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            log("작업 완료 result= " + sum);
            return sum;
        }
    }
}
/* 순서 보장 x
    58.544 [pool-1-thread-1] 작업 시작
    58.544 [pool-1-thread-2] 작업 시작
    00.553 [pool-1-thread-1] 작업 완료 result= 1275
    00.553 [pool-1-thread-2] 작업 완료 result= 3775

    00.553 [     main] task1.result = 1275
    00.553 [     main] task2.result = 3775
    00.554 [     main] task1 + task2 = 5050
    00.554 [     main] End
    
    
Future 없이 결과를 직접 반환받는다면?
    
    1.[요청 스레드] task1 요청 
    2.[요청 스레드] WAITING 상태 & [작업 스레드1] 작업 중
    3.[작업 스레드1] 완료 => [요청스레드] RUNNABLE

    4.[요청 스레드] task2 요청
    5.[요청 스레드] WAITING 상태 & [작업 스레드2] 작업 중
    6.[작업 스레드1] 완료 => [요청스레드] RUNNABLE
    
    task1, task2 를 별도의 흐름으로 동시 실행 불가
    결국 멀티스레드가 아닌 단일스레드 작업이나 마찬가지

Future 반환받는 방식
    1.[요청 스레드] task1 요청 => 바로 Future 인스턴스 반환
    2.[요청 스레드] task2 요청 => 바로 Future 인스턴스 반환

    결과값 요청
    3.[요청 스레드] task1 결과 요청 - Blocking 상태
      [작업 스레드1] & [작업 스레드2] 작업 중

    4.[작업 스레드1] 수행완료 => 작업1의 결과값 반환
    5.[요청 스레드] task2 결과 요청 -> 거의 즉시 반환
    

Future 가 필요한 이유)
- Future 가 없으면, 결과를 받을 때까지 요청스레드는 아무것도 못하고 대기 (다른 작업 동시 수행 불가)
- Future 가 있기에 요청 스레드는 대기하지 않고, 다른 작업 수행 가능
    요청 스레드가 "필요할 때", get()을 호출해서 결과를 받을 수 있음
- 결과적으로 여러 작업을 동시 요청 가능 -> 여러 작업들은 거의 동시에 수행

Future은 요청 스레드를 블로킹 상태로 만들지 않고, 필요한 요청을 모두 수행할 수 있게 해줌
*/