package ch2control.sub1info;

import ch1thread.sub3runnable.HelloRunnable;

import static util.MyLogger.log;

public class ThreadInfoMain {
    public static void main(String[] args) {
        //main 스레드
        Thread mainThread = Thread.currentThread();

        log("mainThread= " + mainThread); // Thread[#1,main,5,main]
        log("mainThread.threadId() = " + mainThread.threadId()); //1 (중복되지 않는 값) - 직접 지정 불가
        log("mainThread.getName() = " + mainThread.getName()); //main
        log("mainThread.getPriority() = " + mainThread.getPriority()); //5 (우선순위 - 1(가장낮음) ~ 10(가장높음)) 기본값 5
        log("mainThread.getThreadGroup() = " + mainThread.getThreadGroup()); //java.lang.ThreadGroup[name=main,maxpri=10]
        log("mainThread.getState() = " + mainThread.getState()); //RUNNABLE (실행될 수 있는 상태)

        //My 스레드
        Thread myThread = new Thread(new HelloRunnable(), "myThread");

        log("myThread= " + myThread); // Thread[#30,myThread,5,main]
        log("myThread.threadId() = " + myThread.threadId()); //30
        log("myThread.getName() = " + myThread.getName()); //myThread
        log("myThread.getPriority() = " + myThread.getPriority()); //5
        log("myThread.getThreadGroup() = " + myThread.getThreadGroup()); //java.lang.ThreadGroup[name=main,maxpri=10]
        log("myThread.getState() = " + myThread.getState()); //NEW (아직 실행 전)

        
        /* 스레드 상태
        - NEW: 스레드가 아직 시작되지 않은 상태
        - RUNNABLE: 스레드가 실행 중이거나 실행될 준비가 된 상태
        - BLOCKED: 스레드가 동기화 락을 기다리는 상태
        - WAITING: 스레드가 다른 스레드의 특정 작업이 완료되기를 기다리는 상태
        - TIMED_WAITING: 일정시간 동안 기다리는 상태
        - TERMINATED: 스레드가 실행을 마친 상태
        * */
    }
}
