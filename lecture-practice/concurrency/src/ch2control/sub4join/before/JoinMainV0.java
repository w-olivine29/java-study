package ch2control.sub4join.before;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV0 {
    public static void main(String[] args) {
        log("start");

        Thread thread1 = new Thread(new Job(), "thread-1");
        Thread thread2 = new Thread(new Job(), "thread-2");
        thread1.start();
        thread2.start();

        log("end");
    }

    static class Job implements Runnable {

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);
            log("작업 완료");
        }
    }


    /* 실행 순서는 보장 X

    [     main] start
    [     main] end
    [ thread-2] 작업 시작
    [ thread-1] 작업 시작
    [ thread-1] 작업 완료
    [ thread-2] 작업 완료

    main 스레드에서는 다른 스레드들을 start() 로 시작시킨 후,
    해당 스레드들의 완료를 기다리지 않고 즉시 자신의 로직을 계속 실행함

    next step)
     만약에 각 스레드들이 종료된 후에 main 스레드를 가장 마지막에 종료하고싶다면?
     (각 스레드들의 작업의 결과를 받아서 처리하고 싶다면?)
    */
}
