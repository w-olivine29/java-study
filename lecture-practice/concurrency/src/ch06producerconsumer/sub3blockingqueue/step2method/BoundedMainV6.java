package ch06producerconsumer.sub3blockingqueue.step2method;

import ch06producerconsumer.BoundedQueue;
import ch06producerconsumer.ConsumerTask;
import ch06producerconsumer.ProducerTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

// BlockingQueue - offer(), poll() -> 스레드 대기x
public class BoundedMainV6 {
    public static void main(String[] args) {

        // 1. BoundedQueue 선택
        //BoundedQueue queue = new BoundedQueueV6_1(2);
        //BoundedQueue queue = new BoundedQueueV6_2(2);
        BoundedQueue queue = new BoundedQueueV6_3(2);

        // BoundedQueue 같이 위임하는 클래스 없이 바로 사용해도 된다
        //BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

        // 2.생산자, 소비자 실행 순서 선택 (반드시 하나만 선택)
        //producerFirst(queue); // 생산자 먼저 실행
        consumerFirst(queue); // 소비자 먼저 실행
    }

    private static void producerFirst(BoundedQueue queue) {
        log(String.format("== [생산자 먼저 실행] 시작, %s ==", queue.getClass().getSimpleName()));
        List<Thread> threads = new ArrayList<>();

        startProducer(queue, threads);
        printAllState(queue, threads);

        startConsumer(queue, threads);
        printAllState(queue, threads);
        log(String.format("== [생산자 먼저 실행] 종료, %s ==", queue.getClass().getSimpleName()));
    }

    private static void consumerFirst(BoundedQueue queue) {

        log(String.format("== [소비자 먼저 실행] 시작, %s ==", queue.getClass().getSimpleName()));
        List<Thread> threads = new ArrayList<>();

        startConsumer(queue, threads);
        printAllState(queue, threads);

        startProducer(queue, threads);
        printAllState(queue, threads);
        log(String.format("== [소비자 먼저 실행] 종료, %s ==", queue.getClass().getSimpleName()));
    }


    private static void printAllState(BoundedQueue queue, List<Thread> threads) {
        System.out.println();
        log("현재 상태 출력 - 큐 데이터: " + queue);
        for (Thread thread : threads) {
            log(thread.getName() + ":" + thread.getState());
        }
    }

    private static void startProducer(BoundedQueue queue, List<Thread> threads) {

        System.out.println();
        log("생산자 시작");

        for (int i = 1; i <= 3; i++) {
            Thread producer = new Thread(new ProducerTask(queue, "data" + i), "producer" + i);
            threads.add(producer);
            producer.start();
            sleep(100); // 원활한 예제 진행을 위한 sleep
        }

    }

    private static void startConsumer(BoundedQueue queue, List<Thread> threads) {

        System.out.println();
        log("소비자 시작");

        for (int i = 1; i <= 3; i++) {
            Thread consumer = new Thread(new ConsumerTask(queue), "consumer" + i);
            threads.add(consumer);
            consumer.start();
            sleep(100); // 원활한 예제 진행을 위한 sleep
        }
    }

}
