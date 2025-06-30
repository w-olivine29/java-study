package ch1thread.sub4multiThreads;

import ch1thread.sub3runnable.HelloRunnable;

import static util.MyLogger.log;

public class ManyThreadV1 {
    public static void main(String[] args) {
        log("main() start");

        HelloRunnable runnable = new HelloRunnable();

        // 별도 스레드 생성
        Thread thread1 = new Thread(runnable);
        thread1.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();

        Thread thread3 = new Thread(runnable);
        thread3.start();
        // 생성된 스레드들은 모두 같은 HelloRunnable 인스턴스의 run()을 각 스택프레임에 올리고 실행

        log("main() end");
    }
}
