package ch09executor.sub3strategy.step6exception;

import ch09executor.RunnableTask;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static util.MyLogger.log;


/* ThreadPoolExecutor
int corePoolSize,
int maximumPoolSize,
long keepAliveTime,
TimeUnit unit,
BlockingQueue<Runnable> workQueue,
RejectedExecutionHandler handler
*/
public class RejectMainV1_Abort {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                1,
                0,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(), //reject를 최대한 빨리 하기 위해 사용 (대기 작업 없게끔)
                new ThreadPoolExecutor.AbortPolicy());

        try {
            executor.submit(new RunnableTask("task1"));
            executor.submit(new RunnableTask("task2"));

        } catch (RejectedExecutionException e) {
            log("요청 초과");
            // 포기 or 다시 시도 등의 로직추가
            log(e);
        }

        executor.close();
    }
}

/*
    52.128 [     main] 요청 초과
    52.128 [pool-1-thread-1] task1시작
    52.130 [     main] java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@b1bc7ed[Not completed, task = java.util.concurrent.Executors$RunnableAdapter@1ddc4ec2[Wrapped task = ch09executor.RunnableTask@133314b]] rejected from java.util.concurrent.ThreadPoolExecutor@5b6f7412[Running, pool size = 1, active threads = 1, queued tasks = 0, completed tasks = 0]
    53.146 [pool-1-thread-1] task1완료


public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
    throw new RejectedExecutionException("Task " + r.toString() +
                                     " rejected from " +
                                     e.toString());
}
*/