package ch1thread.example;

import static util.MyLogger.log;

/* 여러 스레드 사용
Thread-A, Thread-B 두 스레드 만들기
Thread-A는 1초에 한 번씩 "A" 출력
Thread-B는 0.5초에 한 번씩 "B" 출력
해당 프로그램은 강제 종료할 때까지 계속 실행
*/
public class Example4_mySolution2 {
    public static void main(String[] args) {

        Thread threadA = new Thread(new MyRunnable("A",1000),  "Thread-A");
        Thread threadB = new Thread(new MyRunnable("B",500),  "Thread-B");


        threadA.start();
        threadB.start();

    }

    static class MyRunnable implements Runnable {

        private String content;
        private long intervalMs;

        public MyRunnable(String content, long intervalMs) {
            this.content = content;
            this.intervalMs = intervalMs;
        }

        @Override
        public void run() {

            while (true){
                log(content);

                try{
                    Thread.sleep(intervalMs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
