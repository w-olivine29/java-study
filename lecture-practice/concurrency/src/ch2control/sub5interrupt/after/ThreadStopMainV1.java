package ch2control.sub5interrupt.after;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

// 의도) 특정 스레드의 작업 중단시키기 - interrupt() -> catch InterruptedException
public class ThreadStopMainV1 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(4000);
        log("작업 중단 지시 thread.interrupt");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {


        @Override
        public void run() {
            try {
                while (true) {
                    log("작업 중"); // 인터럽트를 걸었을 때 , 이 코드 실행중일 땐 체크 x
                    Thread.sleep(3000); // 인터럽트 당한 상태일 때, 해당 코드 실행 시 InterruptedException 발생
                }
            } catch (InterruptedException e) { // InterruptedException 가 발생하면 다시 Runnable 상태가 됨
                log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted()); //false
                log("interrupt message = " + e.getMessage());
                log("state=" + Thread.currentThread().getState()); //RUNNABLE
            }

            log("자원 정리");
            log("작업 종료");
        }
    }
}

    /* 실행 순서는 보장 x

        41.837 [     work] 작업 중
        42.825 [     main] 작업 중단 지시 thread.interrupt
        42.831 [     main] work 스레드 인터럽트 상태1 = true -> 막 interrupt 발생한 상황
        42.831 [     work] work 스레드 인터럽트 상태2 = false ->  interrupt 당해서 깨어나고 현재는 false 상태 (RUNNABLE)
        42.831 [     work] interrupt message = sleep interrupted
        42.832 [     work] state=RUNNABLE
        42.832 [     work] 자원 정리
        42.832 [     work] 작업 종료


       interrupt() 호출 -> 바로 InterruptedException 발생 X
       sleep() 과 같이 InterruptedException 를 던지는 메서드를 호출 하거나, 호출 중일 때 예외 발생

       인터럽트 적용 후 인터럽트 예외 발생 -> RUNNABLE 상태,  isInterrupted() -> false 상태

       인터럽트 사용 시 대기중인 스레드를 바로 깨워서 실행 가능 상태로 바꿀 수 있다.

       next step)
        sleep를 호출하고 나서야 인터럽트가 발생하는 상황인데, 더 빨리 반응하게 할 수 없을까?
     */
