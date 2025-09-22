package day14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(3);

        try {
            for (int i = 1; i <= 5; i++) {
                int finalI = i;
                es.submit(() -> {
                            System.out.printf("[%s] %d번 작업\n",
                                    Thread.currentThread().getName(), finalI);
                            sleep();
                            System.out.printf("[%s] %d번 작업 완료\n",
                                    Thread.currentThread().getName(), finalI);
                        }
                );
            }
        } finally {
            es.shutdown(); // 새로운 요청은 받지 않고, 현재 실행중인 스레드들이 완료하기까지 대기 후 종료
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
