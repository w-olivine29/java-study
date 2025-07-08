package ch06producerconsumer.sub1waitnotify.before.step1;

import ch06producerconsumer.BoundedQueue;
import ch06producerconsumer.ConsumerTask;
import ch06producerconsumer.ProducerTask;

import java.util.ArrayList;
import java.util.List;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BoundedMainV1 {
    public static void main(String[] args) {

        // 1. BoundedQueue 선택
        BoundedQueue queue = new BoundedQueueV1(2);

        // 2.생산자, 소비자 실행 순서 선택 (반드시 하나만 선택)
        producerFirst(queue); // 생산자 먼저 실행
        //consumerFirst(queue); // 소비자 먼저 실행
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

/* 생산자 먼저 실행
    19.412 [     main] == [생산자 먼저 실행] 시작, BoundedQueueV1 ==

    19.412 [     main] 생산자 시작
    19.417 [producer1] [생산 시도] data1 -> []
    19.419 [producer1] [생산 완료] data1 -> [data1]
    19.523 [producer2] [생산 시도] data2 -> [data1]
    19.523 [producer2] [생산 완료] data2 -> [data1, data2]
    19.635 [producer3] [생산 시도] data3 -> [data1, data2]
    19.636 [producer3] [put] 큐 포화상태, 데이터버림: data3
    19.636 [producer3] [생산 완료] data3 -> [data1, data2]

    19.747 [     main] 현재 상태 출력 - 큐 데이터: [data1, data2]
    19.753 [     main] producer1:TERMINATED
    19.753 [     main] producer2:TERMINATED
    19.754 [     main] producer3:TERMINATED

    19.754 [     main] 소비자 시작
    19.755 [consumer1] [소비 시도]    ?    <- [data1, data2]
    19.756 [consumer1] [소비 완료]  data1  <- [data2]
    19.857 [consumer2] [소비 시도]    ?    <- [data2]
    19.857 [consumer2] [소비 완료]  data2  <- []
    19.968 [consumer3] [소비 시도]    ?    <- []
    19.968 [consumer3] [소비 완료]   null  <- []

    20.079 [     main] 현재 상태 출력 - 큐 데이터: []
    20.079 [     main] producer1:TERMINATED
    20.079 [     main] producer2:TERMINATED
    20.080 [     main] producer3:TERMINATED
    20.080 [     main] consumer1:TERMINATED
    20.080 [     main] consumer2:TERMINATED
    20.080 [     main] consumer3:TERMINATED
    20.081 [     main] == [생산자 먼저 실행] 종료, BoundedQueueV1 ==


   buffer에 데이터가 가득 차있다면, 공간이 생길때까지 기다리게 해야할 필요가 있다.
*/

/* 소비자 먼저 실행

    15.205 [     main] == [소비자 먼저 실행] 시작, BoundedQueueV1 ==

    15.205 [     main] 소비자 시작
    15.210 [consumer1] [소비 시도]    ?    <- []
    15.210 [consumer1] [소비 완료]   null  <- []
    15.311 [consumer2] [소비 시도]    ?    <- []
    15.311 [consumer2] [소비 완료]   null  <- []
    15.421 [consumer3] [소비 시도]    ?    <- []
    15.421 [consumer3] [소비 완료]   null  <- []

    15.531 [     main] 현재 상태 출력 - 큐 데이터: []
    15.536 [     main] consumer1:TERMINATED
    15.536 [     main] consumer2:TERMINATED
    15.536 [     main] consumer3:TERMINATED

    15.536 [     main] 생산자 시작
    15.538 [producer1] [생산 시도] data1 -> []
    15.538 [producer1] [생산 완료] data1 -> [data1]
    15.644 [producer2] [생산 시도] data2 -> [data1]
    15.644 [producer2] [생산 완료] data2 -> [data1, data2]
    15.754 [producer3] [생산 시도] data3 -> [data1, data2]
    15.755 [producer3] [put] 큐 포화상태, 데이터버림: data3
    15.755 [producer3] [생산 완료] data3 -> [data1, data2]

    15.865 [     main] 현재 상태 출력 - 큐 데이터: [data1, data2]
    15.865 [     main] consumer1:TERMINATED
    15.865 [     main] consumer2:TERMINATED
    15.866 [     main] consumer3:TERMINATED
    15.866 [     main] producer1:TERMINATED
    15.866 [     main] producer2:TERMINATED
    15.866 [     main] producer3:TERMINATED
    15.866 [     main] == [소비자 먼저 실행] 종료, BoundedQueueV1 ==

    buffer 에 데이터가 없다면 생길때까지 기다리게 할 필요가 있다.
 */

}
