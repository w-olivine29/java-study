package ch09executor.sub3strategy.step6exception;

import ch09executor.RunnableTask;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/* ThreadPoolExecutor
int corePoolSize,
int maximumPoolSize,
long keepAliveTime,
TimeUnit unit,
BlockingQueue<Runnable> workQueue,
RejectedExecutionHandler handler
*/
public class RejectMainV2_Discard {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                1,
                0,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(), //reject를 최대한 빨리 하기 위해 사용 (대기 작업 없게끔)
                new ThreadPoolExecutor.DiscardPolicy());


        executor.submit(new RunnableTask("task1"));
        executor.submit(new RunnableTask("task2")); // 예외 발생 x, 그냥 조용히 버림

        executor.close();
    }
}

/*
    25.903 [pool-1-thread-1] task1시작
    26.919 [pool-1-thread-1] task1완료


public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
}

DiscardPolicy 의
rejectedExecution(Runnable r, ThreadPoolExecutor e) 내부에는 아무 로직도 없다.
*/