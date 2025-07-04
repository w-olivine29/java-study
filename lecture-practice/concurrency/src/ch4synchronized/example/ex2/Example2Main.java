package ch4synchronized.example.ex2;

import static util.MyLogger.log;

/* 지역변수 공유문제
다음 코드의 실행 결과 예측해보기
localValue 지역 변수에 동시성 문제가 발생하는지 여부에 대해 생각해보기
*/
public class Example2Main {
    public static void main(String[] args) throws InterruptedException {
        MyCounter myCounter = new MyCounter();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                myCounter.count();
            }
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();
    }

    static class MyCounter {

        public void count() {
            int localValue = 0;
            for (int i = 0; i < 1000; i++) {
                localValue = localValue + 1;
            }
            log("결과: " + localValue);
        }
    }
}

/* 내 예측

[스레드1] 결과: 1000
[스레드2] 결과: 1000

localValue 라는 지역변수는 동시성 문제가 발생하지 않을 것으로 예상
인스턴스의 필드가 아닌 지역변수는 각 스택 프레임에서 존재하는 변수이기 때문

+ 보완
스택 영역은 각각의 스레드가 가지는 별도의 메모리 공간 -> 다른 스레드와 공유x
지역변수는 스택영역에 생성 -> 다른 스레드와 공유x
*/
