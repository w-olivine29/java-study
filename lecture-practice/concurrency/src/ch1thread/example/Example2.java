package ch1thread.example;

import static util.MyLogger.log;

/* Runnable 구현
1. CounterRunnable 이라는 클래스 만들기 (Rubbable 인터페이스 구현)
2. CounterRunnable 은 1부터 5까지 숫자를 1초 간격으로 출력 (실습 때 만든 log()를 사용)
3. main() 에서 CounterRunnable 인스턴스를 이용하여 Thread를 생성하고 실행
4. Thread의 이름은 "counter"로 지정
*/
public class Example2 {
    public static void main(String[] args) {

        Thread thread = new Thread(new CounterRunnable(), "counter");
        thread.start();
    }

    static class CounterRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                log("value: " + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    log(e);
                }
            }
        }
    }
}
