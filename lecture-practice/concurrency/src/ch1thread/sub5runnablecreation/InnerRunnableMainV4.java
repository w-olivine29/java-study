package ch1thread.sub5runnablecreation;

import static util.MyLogger.log;

// 람다
public class InnerRunnableMainV4 {
    public static void main(String[] args) {
        log("main() start");

        Thread thread = new Thread(() -> log("run()"));
        thread.start();

        log("main() end");
    }

}
