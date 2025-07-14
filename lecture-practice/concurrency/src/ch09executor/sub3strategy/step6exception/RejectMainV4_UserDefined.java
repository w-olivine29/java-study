package ch09executor.sub3strategy.step6exception;

import ch09executor.RunnableTask;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static util.MyLogger.log;


public class RejectMainV4_UserDefined {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                1,
                0,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(), //reject를 최대한 빨리 하기 위해 사용 (대기 작업 없게끔)
                new MyRejectedExecutionHandler());
        
            executor.submit(new RunnableTask("task1"));
            executor.submit(new RunnableTask("task2"));
            executor.submit(new RunnableTask("task3"));
            executor.submit(new RunnableTask("task4"));

        executor.close();
    }

    static class MyRejectedExecutionHandler implements RejectedExecutionHandler {

        // 거절 된 누적 작업 수
        static AtomicInteger count = new AtomicInteger(0);
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            int i = count.incrementAndGet();
            log("[경고] 거절된 누적 작업 수: " + i);
            
            // 거절된 작업은 버리고, 로그를 남김
        }
    }
}

/*
    43.834 [pool-1-thread-1] task1시작
    43.834 [     main] [경고] 거절된 누적 작업 수: 1
    43.835 [     main] [경고] 거절된 누적 작업 수: 2
    43.835 [     main] [경고] 거절된 누적 작업 수: 3
    44.843 [pool-1-thread-1] task1완료
*/