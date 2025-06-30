package ch1thread.sub5runnablecreation;

import static util.MyLogger.log;

// 익명클래스
public class InnerRunnableMainV3 {
    public static void main(String[] args) {
        log("main() start");


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log("run()");
            }
        });
        thread.start();

        log("main() end");
    }

}
