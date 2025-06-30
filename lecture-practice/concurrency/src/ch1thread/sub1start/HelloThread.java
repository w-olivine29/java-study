package ch1thread.sub1start;

public class HelloThread extends Thread {


    // 스레드가 실행할 코드를 재정의
    // 해당 메서드는 start()를 통해서 호출되어야함
    @Override
    public void run() {

        // 해당 코드를 실행하는 스레드 객체 조회 + 이름 조회
        //System.out.println(Thread.currentThread() + ": run()");
        System.out.println(Thread.currentThread().getName() + ": run()");
    }
}
