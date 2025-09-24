package ch03.functionalinterface.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallablePrintThreadExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<String> task = () -> {
            String result = "result123";
            System.out.println("[" + Thread.currentThread().getName() + "] " + result);
            return result;
        };
        Future<String> future = executor.submit(task);

        try {
            System.out.println("[" + Thread.currentThread().getName() + "]" + "Callable Result=" + future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
