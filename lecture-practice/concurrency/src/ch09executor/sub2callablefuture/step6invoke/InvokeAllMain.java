package ch09executor.sub2callablefuture.step6invoke;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static util.MyLogger.log;

public class InvokeAllMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService es = Executors.newFixedThreadPool(10);

        CallableTask task1 = new CallableTask("task1", 1000);
        CallableTask task2 = new CallableTask("task2", 2000);
        CallableTask task3 = new CallableTask("task3", 3000);

        //<T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
        // 모든 작업이 완료돼야 Future 리스트를 반환 (invokeAll 호출 시에 블로킹)
        List<Future<Integer>> futures = es.invokeAll(List.of(task1, task2, task3));

        //get() 할때는 이미 완료된 상태 (논블로킹)
        for (Future<Integer> future : futures) {
            Integer value  = future.get();
            log("value= " + value);
        }
        es.close();
    }
}
/*
    29.725 [pool-1-thread-2] task2실행
    29.725 [pool-1-thread-1] task1실행
    29.725 [pool-1-thread-3] task3실행
    30.735 [pool-1-thread-1] task1완료
    31.742 [pool-1-thread-2] task2완료
    32.733 [pool-1-thread-3] task3완료
    32.733 [     main] value= 1000
    32.733 [     main] value= 2000
    32.734 [     main] value= 3000

invokeAll()
호출 시점에서 모든 작업 완료까지 블로킹
*/