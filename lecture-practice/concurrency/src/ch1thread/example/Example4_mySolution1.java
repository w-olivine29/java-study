package ch1thread.example;

import static util.MyLogger.log;

/* 여러 스레드 사용
Thread-A, Thread-B 두 스레드 만들기
Thread-A는 1초에 한 번씩 "A" 출력
Thread-B는 0.5초에 한 번씩 "B" 출력
해당 프로그램은 강제 종료할 때까지 계속 실행
*/
public class Example4_mySolution1 {
    public static void main(String[] args) {

        MyThread threadA = new MyThread("A", 1000);
        MyThread threadB = new MyThread("B", 500);

        threadA.start();
        threadB.start();

    }

    static class MyThread extends Thread {

        private String name;
        private long intervalMs;

        public MyThread(String name, long intervalMs) {
            super("Thread-" + name);
            this.name = name;
            this.intervalMs = intervalMs;
        }

        @Override
        public void run() {

            while (true){
                log(name);

                try{
                    Thread.sleep(intervalMs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
