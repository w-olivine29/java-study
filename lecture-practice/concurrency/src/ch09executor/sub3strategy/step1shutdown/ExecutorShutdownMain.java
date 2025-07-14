package ch09executor.sub3strategy.step1shutdown;

import ch09executor.RunnableTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static util.ExecutorUtils.printState;
import static util.MyLogger.log;

public class ExecutorShutdownMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new RunnableTask("taskA"));
        es.execute(new RunnableTask("taskB"));
        es.execute(new RunnableTask("taskC"));
        es.execute(new RunnableTask("longTask",100_000)); //100초 대기

        printState(es);

        log("== shutdown 시작 ==");
        shutdownAndAwaitTermination(es);
        log("== shutdown 완료 ==");
        printState(es);
        
    }

    // 공식 매뉴얼에 있는 방식을 약간 편하게 다듬는 것
    private static void shutdownAndAwaitTermination(ExecutorService es) {

        //논블로킹, 새로운 작업 받지않고, 처리 중이거나 큐에 대기중인 작업은 처리, 이후에 풀의 스레드 종료
        es.shutdown();

        try{
            // shutdown() 이 논블로킹이기때문에, 메인스레드는 직접 대기할 필요가 있음
            // 이미 대기중인 작업들이 완료될 때까지 대기 (지정된 시간까지만 대기)
            if(!es.awaitTermination(10, TimeUnit.SECONDS)){ //10초 기다려도, 작업이 남아있다면
                // 정상 종료가 너무 오래 걸리면
                log("서비스 정상 종료 실패 => 강제 종료 시도");

                // 실행 작업 중단, 대기 작업 반환, 즉시 종료
                // 인터럽트 발생시킴
                // 논블로킹 메서드
                es.shutdownNow();
                
                // shutdownNow() 또한 논블로킹이기때문에, 메인스레드는 직접 대기해야함
                // 작업이 완전히 취소될 때까지 대기 (인터럽트, 자원 정리 등 시간이 필요할 것임)
                if(!es.awaitTermination(10,TimeUnit.SECONDS)){

                    // 지정시간까지 더 기다렸지만 서비스 종료실패 -> 로그를 남김
                    // 이런 상황은 인터럽트 걸어도 Thread가 안 꺼지는 상황
                    // Thread가 인터럽트를 못 받게 설계되어 있으면 안 꺼지는 등의 문제가 있을 수 있음
                    log("서비스가 종료되지 않았습니다.");
                }
            }

        }catch (InterruptedException e){
            // awaitTermination() 으로 대기중인 현재 스레드가 인터럽트 될 수 있다.
            // (다른 스레드에서, shutdown 을 요청한 메인 스레드에 인터럽트를 걸었을 경우)
            
            // 정상 종료를 기다리지 않고 즉시 강제 종료해라
            es.shutdownNow();
        }

    }
}

/* 
    17.558 [pool-1-thread-1] taskA시작
    17.558 [pool-1-thread-2] taskB시작
    17.561 [     main] [pool= 2, active= 2, queuedTasks= 2, completedTask= 0]
    17.561 [     main] == shutdown 시작 ==
    18.573 [pool-1-thread-2] taskB완료
    18.573 [pool-1-thread-1] taskA완료
    18.573 [pool-1-thread-2] taskC시작
    18.573 [pool-1-thread-1] longTask시작
    19.581 [pool-1-thread-2] taskC완료
    
    10초 대기
    
    27.564 [     main] 서비스 정상 종료 실패 => 강제 종료 시도
    27.564 [pool-1-thread-1] 인터럽트 발생, sleep interrupted
    27.566 [     main] == shutdown 완료 ==
    27.566 [     main] [pool= 0, active= 0, queuedTasks= 0, completedTask= 4]
Exception in thread "pool-1-thread-1" java.lang.RuntimeException: java.lang.InterruptedException: sleep interrupted
	at util.ThreadUtils.sleep(ThreadUtils.java:16)
	at ch09executor.RunnableTask.run(RunnableTask.java:23)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	at java.base/java.lang.Thread.run(Thread.java:1583)
Caused by: java.lang.InterruptedException: sleep interrupted
	at java.base/java.lang.Thread.sleep0(Native Method)
	at java.base/java.lang.Thread.sleep(Thread.java:509)
	at util.ThreadUtils.sleep(ThreadUtils.java:13)
	... 4 more
*/

/*
서비스를 종료할 때, 
기본적으로 우아한 종료 선택, 
우아한 종료가 되지 않으면, 강제종료 하는 방식으로 접근하기 

우아한 종료)
    새로운 요청 막고, 이미 진행중인 요청은 모두 완료한 후 종료 (서비스를 안정적으로 종료하는 방식)
*/
