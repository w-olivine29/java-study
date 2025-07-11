package ch08collection.sub1reason.step2beforesync;


import ch08collection.sub1reason.SimpleList;

import static util.MyLogger.log;

public class SimpleListMainV2 {
    public static void main(String[] args) throws InterruptedException {
        test(new BasicList());

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

/*
test1
    09.398 [     main] BasicList
    09.516 [ Thread-1] Thread-1: list.add(A)
    09.516 [ Thread-2] Thread-2: list.add(B)
    09.516 [     main] [B] size= 1, capacity= 5

test2
    58.972 [     main] BasicList
    59.090 [ Thread-2] Thread-2: list.add(B)
    59.090 [ Thread-1] Thread-1: list.add(A)
    59.091 [     main] [B, null] size= 2, capacity= 5

컬렉션 프레임워크에 속하는 대부분의 자료구조들은 원자적으로 보이는 연산들도, 내부에서는 수 많은 연산들이 함께 사용된다.
*/
