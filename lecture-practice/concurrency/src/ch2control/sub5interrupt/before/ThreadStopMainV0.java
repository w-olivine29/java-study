package ch2control.sub5interrupt.before;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

// 의도) 특정 스레드의 작업 중단시키기 - 변수사용
public class ThreadStopMainV0 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(4000);
        log("작업 중단 지시 runFlag = false");
        task.runFlag = false;
    }

    static class MyTask implements Runnable {

        volatile boolean runFlag = true;

        @Override
        public void run() {
            while (runFlag) {
                log("작업 중");
                sleep(3000);
            }
            log("자원 정리");
            log("작업 종료");
        }
    }
}

    /* 실행 순서는 보장 x

         [     work] 작업 중
         [     work] 작업 중
         [     main] 작업 중단 지시 runFlag = false
         
         ... 대략 2초의 간격

         [     work] 자원 정리
         [     work] 작업 종료

       main 스레드가 작업 중단 지시해도 work 스레드가 바로 반응하지 않음
       while 조건문을 3초마다 확인하는 상태이며 (sleep 상태), 작업 지시 타이밍이 맞지 않았기 때문
       
       next step)
            sleep() 처럼 대기하는 스레드를 강제로 깨우고, 작업을 종료시켜보자
     */
