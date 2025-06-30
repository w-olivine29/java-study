package ch1thread.sub5runnablecreation;

import static util.MyLogger.log;

// 중첩 클래스
public class InnerRunnableMainV1 {
    public static void main(String[] args) {
        log("main() start");

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        log("main() end");
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            log("run()");
        }
    }
}
