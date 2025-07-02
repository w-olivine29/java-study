package ch2control.sub5interrupt.after;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

// 의도) 특정 스레드의 작업 중단시키기 - interrupt() -> Thread.interrupted()
public class ThreadStopMainV3 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(100);
        log("작업 중단 지시 thread.interrupt");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {


        @Override
        public void run() {

            while (!Thread.interrupted()) { // 인터럽트 상태 확인, 상태 변경 o
                log("작업 중");
            }
            log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted()); //true


            // 인터럽트를 당한 후 남은 작업을 실행하는 과정
            try {
                log("자원 정리");
                Thread.sleep(1000); // 예외 발생 x (Thread.interrupted() 에서 다시 상태를 인터럽트 상태를 false로 바꿨기때문)
                log("자원 종료");
            } catch (InterruptedException e) {
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태3 = " + Thread.currentThread().isInterrupted()); //false 로 돌아옴
            }
            log("작업 종료");
        }
    }
}

    /* 실행 순서는 보장 x

        010 [     work] 작업 중
        010 [     main] 작업 중단 지시 thread.interrupt
        010 [     work] 작업 중
        014 [     work] work 스레드 인터럽트 상태2 = false
        014 [     work] 자원 정리
        014 [     main] work 스레드 인터럽트 상태1 = false
        018 [     work] 자원 종료
        018 [     work] 작업 종료


       보통 인터럽트의 상태를 직접 체크해야하는 경우 Thread.interrupted() 사용
       (isInterrupted()는 특정 스레드의 상태 확인만 할 때 사용)

     */
