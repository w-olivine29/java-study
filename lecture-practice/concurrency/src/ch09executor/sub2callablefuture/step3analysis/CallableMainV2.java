package ch09executor.sub2callablefuture.step3analysis;

import java.util.Random;
import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

// future 분석
public class CallableMainV2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyCallable task = new MyCallable();

        ExecutorService es = Executors.newFixedThreadPool(1);

        log("submit() 호출");
        Future<Integer> future = es.submit(new MyCallable());
        log("future 즉시 반환, future =" + future);

        log("future.get() [블로킹] 메서드 호출 시작 => main 스레드 WAITING");
        Integer result = future.get(); //main 스레드는 해당 작업 결과가 나올 때 까지 대기
        log("future.get() [블로킹] 메서드 호출 완료 => main 스레드 RUNNABLE");
        
        log("result value = " + result);
        log("future 완료, future = " + future);
        es.close();
    }

    static class MyCallable implements Callable<Integer> {

        // Runnable의 run() 과 달리 반환타입 존재 -> 결과값을 저장할 별도의 필드 필요 x
        // throws Exception
        @Override
        public Integer call() throws Exception {
            log("Callable 시작");
            sleep(2000);
            int value = new Random().nextInt(10);

            log("create value =" + value);
            log("Callable 완료");
            return value;
        }
    }
}

/*
57.859 [     main] submit() 호출
57.862 [pool-1-thread-1] Callable 시작
57.863 [     main] future 즉시 반환, future =java.util.concurrent.FutureTask@6193b845[Not completed, task = ch09executor.sub2callablefuture.step3analysis.CallableMainV2$MyCallable@4d405ef7]
57.863 [     main] future.get() [블로킹] 메서드 호출 시작 => main 스레드 WAITING

59.882 [pool-1-thread-1] create value =9
59.882 [pool-1-thread-1] Callable 완료
59.883 [     main] future.get() [블로킹] 메서드 호출 완료 => main 스레드 RUNNABLE

59.883 [     main] result value = 9
59.884 [     main] future 완료, future = java.util.concurrent.FutureTask@6193b845[Completed normally]


submit(task)
 => FutureTask 생성 - [작업상태, 결과값 필드 등, 작업 task(넘긴 Callable)]
 => FutureTask 인스턴스 참조값을 즉시 반환 & Executor의 블로킹 큐에  들어감
 => FutureTask 를 스레드가 수행(소모)

구현&상속 구조
 FutureTask<V> -> RunnableFuture<V> -> Runnable, Future<V>
 
 Runnable을 상속하고있기 때문에, Thread가 수행 가능
    FutureTask.run() -> Callable.call()


future.get()
    요청 스레드는 Future의 인스턴스 참조를 가지고 있음
    요청 스레드가 Future.get() 호출 시 작업의 결과를 얻기 위해 대기
     => Future의 상태가 완료로 변경될 때까지 대기 (요청 스레드는 WAITING 상태로 변경)
        (마치 락을 얻을 때 처럼 결과를 위해 대기)
     => Future 의 task 수행 완료
        => 반환결과 담기
        => 상태 완료 변경
        => get() 요청 스레드 깨우기 (WAITING -> RUNNABLE)
    

블로깅(Blocking) : 스레드가 어떤 결과를 얻기 위해 대기하는 것
    블로킹 메서드 예시)
       Thread.join(), Future.get()


- submit(callable) 은 왜 바로 결과를 반환하지 않고, Future 라는 객체를 반환하는가?
    Callable 의 call은 스레드 풀의 다른 스레드가 실행 -> 언제 실행 완료될지 정확하게 예측불가
    따라서 결과를 즉시 반환받는 것은 불가능하기때문에,
    결과 대신, 결과를 나중에 받을 수 있는 Future 이라는 객체를 반환
    즉 Future는 전달한 작업의 미래 결과를 담고 있다


근데 어차피 작업 결과값을 얻으려면 future.get() 을 호출해야하고,
이 시점에서  WAITING 상태로 기다리는데, 왜 굳이 Future로 받게끔 했는가?

next step) Future 개념의 필요성
 => step3application 참고

*/
