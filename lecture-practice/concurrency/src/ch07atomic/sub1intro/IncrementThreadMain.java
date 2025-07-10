package ch07atomic.sub1intro;

import ch07atomic.sub1intro.after.MyAtomicInteger;
import ch07atomic.sub1intro.before.BasicInteger;
import ch07atomic.sub1intro.before.SyncInteger;
import ch07atomic.sub1intro.before.VolatileInteger;

import java.util.ArrayList;
import java.util.List;

import static util.ThreadUtils.sleep;

public class IncrementThreadMain {

    public static final int THREAD_COUNT = 1000;

    public static void main(String[] args) throws InterruptedException {
        test(new BasicInteger());
        test(new VolatileInteger());
        test(new SyncInteger());
        test(new MyAtomicInteger());
    }

    private static void test(IncrementInteger incrementInteger) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                sleep(10); // 다른 스레드와 동시 실행하는 시나리오를 위함
                incrementInteger.increment();
            }
        };
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int result = incrementInteger.get();
        System.out.println(incrementInteger.getClass().getSimpleName() + " result: " + result);
    }

/*
BasicInteger result: 982
VolatileInteger result: 965
SyncInteger result: 1000
MyAtomicInteger result: 1000
*/

}
