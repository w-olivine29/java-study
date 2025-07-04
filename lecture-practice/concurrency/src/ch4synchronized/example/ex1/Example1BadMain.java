package ch4synchronized.example.ex1;

/* 공유 자원 문제
다음 코드의 결과는 20000 이 되어야하며, 이 코드의 문제점 찾아서 해결
이 코드에서 다른 부분은 변경하면 안되며, Counter 클래스 내부만 수정
*/
public class Example1BadMain {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("결과: " + counter.getCount());
    }

    static class Counter {
        private int count = 0;
        public void increment() {
            count = count + 1;
        }

        public int getCount() {
            return count;
        }
    }
}