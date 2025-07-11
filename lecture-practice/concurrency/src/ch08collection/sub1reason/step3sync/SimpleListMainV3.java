package ch08collection.sub1reason.step3sync;


import ch08collection.sub1reason.SimpleList;

import static util.MyLogger.log;

public class SimpleListMainV3 {
    public static void main(String[] args) throws InterruptedException {
        test(new SyncList());

    }

    // 리스트 종류에 따른 멀티스레드 환경 동시성 테스트
    private static void test(SimpleList list) throws InterruptedException {
        log(list.getClass().getSimpleName());
        
        // A를 리스트에 저장하는 로직
        Runnable addA = new Runnable() {
            @Override
            public void run() {
                list.add("A");
                log("Thread-1: list.add(A)");
            }
        };
        
        // B를 리스트에 저장하는 로직
        Runnable addB = new Runnable() {
            @Override
            public void run() {
                list.add("B");
                log("Thread-2: list.add(B)");
            }
        };

        Thread thread1 = new Thread(addA, "Thread-1");
        Thread thread2 = new Thread(addB, "Thread-2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        log(list);
    }
}

/* 순서보장 x

    29.306 [     main] SyncList
    29.424 [ Thread-2] Thread-2: list.add(B)
    29.539 [ Thread-1] Thread-1: list.add(A)
    29.539 [     main] [B, A] size= 2, capacity= 5

*/
