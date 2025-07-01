package ch2control.sub2lifecycle;

import static util.MyLogger.log;

public class ThreadStateMain {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable(), "myThread");
        log("myThread.state1 = " + thread.getState()); //[     main] myThread.state1 = NEW

        log("myThread.start()");
        thread.start();

        //main 스레드에서 myThread 상태를 구할 타이밍을 위해 sleep
        Thread.sleep(1000); //main 메서드에서는 throws 가능
        log("myThread.state3 = " + thread.getState()); //TIMED_WAITING (상태를 가져올 당시 sleep 중)

        Thread.sleep(4000);
        log("myThread.state5 = " + thread.getState()); //TERMINATED
    }

    static class MyRunnable implements Runnable {

        // run() 안에서는 반드시 체크 예외를 직접 처리해야한다.
        @Override
        public void run() {
            try {
                log("start");
                log("myThread.state2 = " + Thread.currentThread().getState()); //RUNNABLE
                log("sleep() start");

                Thread.sleep(3000); //MyThread

                log("myThread.state4 = " + Thread.currentThread().getState()); //RUNNABLE

                log("sleep() end");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
