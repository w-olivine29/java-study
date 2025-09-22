package day13;

public class SynchronizedExample {
    public static void main(String[] args) throws InterruptedException {

        SynchronizedExample.Counter counter = new SynchronizedExample.Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increase();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        // 현재 메인스레드가 해당 스레드들이 끝나기까지 대기
        thread1.join();
        thread2.join();
        System.out.println("count 결과: " + counter.count);
    }

    static class Counter {
        private int count;

        synchronized void increase() {
            count++;
        }

//         void increase() {
//            count++;
//        }
    }
}
