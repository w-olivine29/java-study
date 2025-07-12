package ch09executor.sub2callablefuture.step3application;

import java.util.concurrent.*;

import static util.MyLogger.log;

// Future의 get() 처럼 블로킹 되는 메서드는 항상 주의!!!!
public class SumTaskMainV2_Bad {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        SumTask sumTask1 = new SumTask(1, 50);
        SumTask sumTask2 = new SumTask(51, 100);

        ExecutorService es = Executors.newFixedThreadPool(2);
        
        // 잘못된 사용 예
        Future<Integer> future1 = es.submit(sumTask1);
        Integer sum1 = future1.get(); // Blocking - 2초 대기

        Future<Integer> future2 = es.submit(sumTask2);
        Integer sum2 = future2.get(); // Blocking - 2초 대기

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
    36.165 [pool-1-thread-1] 작업 시작
    38.192 [pool-1-thread-1] 작업 완료 result= 1275

    38.193 [pool-1-thread-2] 작업 시작
    40.203 [pool-1-thread-2] 작업 완료 result= 3775

    40.203 [     main] task1.result = 1275
    40.203 [     main] task2.result = 3775
    40.204 [     main] task1 + task2 = 5050
    40.204 [     main] End
*/