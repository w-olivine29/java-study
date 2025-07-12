package ch09executor.sub2callablefuture.step1runnable;

import java.util.Random;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class RunnableMain {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable task = new MyRunnable();
        Thread thread = new Thread(task, "Thread-1");
        thread.start();
        thread.join(); // 클라이언트인 main 스레드가 별도의 스레드에서 만든 결과값을 얻으려면, 해당 스레드가 종료될 때까지 기다려야함

        int result = task.value;
        log("result value =" + result);
    }

    static class MyRunnable implements Runnable {
        int value;

        @Override
        public void run() {
            log("Runnable 시작");
            sleep(2000);
            value = new Random().nextInt(10);
            log("create value=" + value);
            log("Runnable 완료");
        }
    }
}

/* Runnable의 단점

별도의 스레드에서 만든 값을 가져오는 과정이 복잡

- 작업 스레드에서는 결과값을 어딘가에 보관
- 요청 스레드(main) 는 작업 스레드의 작업이 끝날 때까지 join()을 통해 대기
- 보관 된 값 꺼내기

    next step) 작업 스레드는 값을 직접 반환, 요청스레드가 그 값을 직접 받을 수 없는가?
        -> Executor 프레임워크가 Callable & Future 인터페이스 제공
*/
