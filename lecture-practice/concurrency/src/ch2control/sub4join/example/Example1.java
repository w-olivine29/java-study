package ch2control.sub4join.example;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

/* 코드 실행 전 로그 출력형태, 총 실행 시간 예측하기
*/
public class Example1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyTask(), "t1");
        Thread t2 = new Thread(new MyTask(), "t2");
        Thread t3 = new Thread(new MyTask(), "t3");

        t1.start(); //3초 소요
        t1.join();

        t2.start(); //3초 소요
        t2.join();

        t3.start(); //3초 소요
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
