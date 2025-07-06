package ch5concurrentlock.sub1locksupport;

import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

//LockSupport.park()
public class LockSupportMainV1 {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new ParkTest());
        thread1.start();
        
        // 잠시 대기하여 Thread-1이 park 상태에 빠질 시간을 줌
        sleep(100);
        log("Thread-1 state: " + thread1.getState());

        log("main 스레드 -> unpark(Thread-1)");
        //LockSupport.unpark(thread1); // 1. unpark

        thread1.interrupt(); // 2.interrupt

    }

    static class ParkTest implements Runnable {
        @Override
        public void run() {
            log("park 시작");
            LockSupport.park(); // WAITING 상태
            // 다른 스레드가 unpark 해주거나, interrupt 걸지 않으면 풀리지 못함

            log("park 종료, state: " + Thread.currentThread().getState());
            log("인터럽트 상태, state: " + Thread.currentThread().isInterrupted());
        }
    }
}


/* main 스레드 -> unpark(Thread-1)

    30.325 [ Thread-0] park 시작
    30.417 [     main] Thread-1 state: WAITING
    30.418 [     main] main 스레드 -> unpark(Thread-1)
    30.418 [ Thread-0] park 종료, state: RUNNABLE
    30.422 [ Thread-0] 인터럽트 상태, state: false
*/



/* main 스레드 -> thread1.interrupt()

    56.787 [ Thread-0] park 시작
    56.888 [     main] Thread-1 state: WAITING
    56.888 [     main] main 스레드 -> unpark(Thread-1)
    56.888 [ Thread-0] park 종료, state: RUNNABLE
    56.891 [ Thread-0] 인터럽트 상태, state: true

    WAITING 상태의 스레드는 인터럽트를 걸어서 깨울 수 있음 (상태는 계속 인터럽트 당한 상태)
*/




