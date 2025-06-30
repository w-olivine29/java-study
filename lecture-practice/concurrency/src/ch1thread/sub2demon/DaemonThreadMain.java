package ch1thread.sub2demon;

public class DaemonThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true); //데몬스레드로  설정 (이후에는 변경불가)
        daemonThread.start();

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }

    static class DaemonThread extends Thread {


        // run 에서는 체크예외 throws 불가
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run() start");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": run() end");
        }
    }



    /* 출력결과
    main: main() start
    main: main() end
    Thread-0: run() start

    DaemonThread의 run이 완료되지 않고 끝나버렸다.
    사용자 스레드가 모두 끝나면 JVM이 종료되기 때문이다
    */
}
