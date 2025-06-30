package ch1thread.sub4multiThreads;

import ch1thread.sub3runnable.HelloRunnable;

import static util.MyLogger.log;

public class ManyThreadV2 {
    public static void main(String[] args) {
        log("main() start");

        HelloRunnable runnable = new HelloRunnable();

        // 별도 스레드 생성
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
        // 생성된 스레드들은 모두 같은 HelloRunnable 인스턴스의 run()을 각 스택프레임에 올리고 실행

        log("main() end");
    }


    /* 실행 결과 (실행마다 달라질 수 있음)

    ...
    Thread-91: run()
    Thread-94: run()
    16:58:10.693 [     main] main() end
    Thread-95: run()
    Thread-96: run()
    Thread-97: run()
    ...
    */
}
