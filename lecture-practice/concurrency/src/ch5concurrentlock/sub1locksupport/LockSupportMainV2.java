package ch5concurrentlock.sub1locksupport;

import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

//LockSupport.parkNanos()
public class LockSupportMainV2 {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new ParkTest());
        thread1.start();
        
        // 잠시 대기하여 Thread-1이 park 상태에 빠질 시간을 줌
        sleep(100);
        log("Thread-1 state: " + thread1.getState());

    }

    static class ParkTest implements Runnable {
        @Override
        public void run() {
            log("park 시작");

            LockSupport.parkNanos(2_000_000_000); // TIMED_WAITING -> 2초 뒤에 RUNNABLE  ( 100만 나노초 = 1밀리초)

            log("park 종료, state: " + Thread.currentThread().getState());
            log("인터럽트 상태, state: " + Thread.currentThread().isInterrupted());
        }
    }
}


/*
    45.272 [ Thread-0] park 시작
    45.361 [     main] Thread-1 state: TIMED_WAITING
    47.273 [ Thread-0] park 종료, state: RUNNABLE
    47.277 [ Thread-0] 인터럽트 상태, state: false
*/





