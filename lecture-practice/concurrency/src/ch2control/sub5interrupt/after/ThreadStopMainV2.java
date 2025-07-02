package ch2control.sub5interrupt.after;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

// 의도) 특정 스레드의 작업 중단시키기 - interrupt() -> isInterrupted()
public class ThreadStopMainV2 {
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

            while (!Thread.currentThread().isInterrupted()) { // 인터럽트 상태 확인 -> InterruptedException 와는 다르게 상태변경 x
                log("작업 중");
            }
            log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted()); //true


            // 인터럽트를 당한 후 남은 작업을 실행하는 과정
            try {
                log("자원 정리");
                Thread.sleep(1000); // 바로 예외 발생 (isInterrupted() -> true 인 상황이기 때문)
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

        167 [     work] 작업 중
        167 [     main] 작업 중단 지시 thread.interrupt
        167 [     work] 작업 중
        177 [     work] work 스레드 인터럽트 상태2 = true
        178 [     work] 자원 정리
        177 [     main] work 스레드 인터럽트 상태1 = true
        178 [     work] 자원 정리 실패 - 자원 정리 중 인터럽트 발생
        178 [     work] work 스레드 인터럽트 상태3 = false
        178 [     work] 작업 종료


       의도한 바는 while() 문을 탈출하기 위해 인터럽트를 사용한 것이나, 
       탈출 후에도 인터럽트가 발생하는 상황
       (스레드의 인터럽트 상태를 되돌리지 않으면 이후에도 계속 인터럽트가 발생하는 상황)

       이것이 자바에서는 인터럽트가 한번 발생 시, 스레드의 인터럽트 상태를 다시 정상으로 돌리는 이유이다.

       next step)
        인터럽트 상태를 확인 후에 , 인터럽트 상태를 정상으로 돌려두자
     */
