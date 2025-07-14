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
public class RejectMainV3_CallerRuns {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                1,
                0,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(), //reject를 최대한 빨리 하기 위해 사용 (대기 작업 없게끔)
                new ThreadPoolExecutor.CallerRunsPolicy());


        executor.submit(new RunnableTask("task1"));
        executor.submit(new RunnableTask("task2"));
        executor.submit(new RunnableTask("task3"));
        executor.submit(new RunnableTask("task4"));


        executor.close();
    }
}

/*
    28.388 [pool-1-thread-1] task1시작 -> 풀에 스레드가 있으니까 수행
    28.388 [     main] task2시작 -> 풀에 스레드가 없고, 보관할 큐도 없음 -> 작업 요청한 스레드가 직접 수행
    29.391 [pool-1-thread-1] task1완료
    29.391 [     main] task2완료
    29.391 [     main] task3시작  -> 작업 요청한 스레드가 직접 수행
    30.396 [     main] task3완료
    30.396 [pool-1-thread-1] task4시작
    31.398 [pool-1-thread-1] task4완료


생산자 스레드가 소비자 대신 일을 수행 (작업요청 스레드가 스레드풀의 스레드 대신 수행)
    -> 생산자 스레드가 작업의 요청뿐만 아니라 직접 일을 수행하게되면서, 작업의 생산자체가 느려짐
    -> 작업의 생산 속도가 너무 빠르다면, "생산 속도를 조절" 할 수 있다는 점
    
    
    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
    if (!e.isShutdown()) {
        r.run(); //별도의 스레드가 아닌 요청 스레드가 직접 수행
    }
}
CallerRunsPolicy 정책은 shutdown() 이후에도 작업 수행해버리기때문에, 
shutdown() 조건을 체크하여 작업 수행하지 않도록 한다

*/