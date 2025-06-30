package ch1thread.example;

import static util.MyLogger.log;

/* Thread 상속
 1. Thread 클래스를 상속받은 CounterThread 라는 클래스 만들기
 2. 해당 스레드는 1부터 5까지의 숫자를 1초 간격으로 출력 (실습 때 만든 log()를 사용)
 3. main() 에서 CounterThread 클래스를 만들고 실행
*/
public class Example1 {
    public static void main(String[] args) {
        CounterThread counterThread = new CounterThread();
        counterThread.start();
    }

     static class CounterThread extends Thread {

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                log("value: " + i);

                try{
                    sleep(1000);
                }catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
