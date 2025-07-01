package ch2control.sub4join.example;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

//Example1 의 코드를 변경하여 전체 실행 시간 3초로 앞당기기
public class Example2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Example1.MyTask(), "t1");
        Thread t2 = new Thread(new Example1.MyTask(), "t2");
        Thread t3 = new Thread(new Example1.MyTask(), "t3");

        // 각 스레드가 거의 동시에 시작 (총 약 3초 소요)
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println("모든 스레드 실행 완료");
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                log(i);
                sleep(1000);
            }
        }
    }
}
