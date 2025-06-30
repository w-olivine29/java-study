package ch1thread.sub5runnablecreation;

import static util.MyLogger.log;

// 익명클래스
public class InnerRunnableMainV2 {
    public static void main(String[] args) {
        log("main() start");

        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                log("run()");
            }
        };

        Thread thread = new Thread(myRunnable);
        thread.start();

        log("main() end");
    }

}
