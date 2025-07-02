package ch2control.sub6yield;

public class YieldMain {

    static final int THREAD_COUNT = 1000;

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }

    // run() 에 있는 1,2,3 주석 변경하면서 실행해보기
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
                //1. empty (sleep, yield 없이 호출)
                //sleep(1); //2. sleep - TIMED_WAITING (스케줄링 큐에서 아예 제외)
                Thread.yield(); //3. yield - RUNNABLE 상태 유지한채로 다시 스케줄링 큐에 들어가는 것
            }
        }
    }
}

/* RUNNABLE
자바의 스레드가 RUNNABLE인 경우 운영체제의 스케줄링의 상태
- 실행 상태(Running): 스레드가 CPU에서 실제로 실행 중
- 실행 대기 상태(Ready): 스레드가 실행될 준비가 되었지만, CPU가 바빠서 스케줄링 큐에서 대기 중

자바에서는 이 두 상태를 구분 x
*/

/* Thread.yield()
현재 실행 중인 스레드가 자발적으로 CPU를 양보 -> 다른 스레드가 실행될 수 있도록 한다.

해당 스레드는 RUNNABLE 상태를 유지하면서 CPU 양보
다시 스케줄링 큐에 들어가면서 다른 스레드에게 CPU 사용 기회를 넘김

운영체제에게 힌트를 줄 뿐, 강제적인 실행 순서 지정 x
반드시 다른 스레드가 실행되는 것은 아님
*/