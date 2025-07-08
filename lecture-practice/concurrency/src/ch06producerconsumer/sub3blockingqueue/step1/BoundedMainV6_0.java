package ch06producerconsumer.sub3blockingqueue.step1;

import ch06producerconsumer.BoundedQueue;
import ch06producerconsumer.ConsumerTask;
import ch06producerconsumer.ProducerTask;

import java.util.ArrayList;
import java.util.List;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BoundedMainV6_0 {
    public static void main(String[] args) {

        // 1. BoundedQueue 선택
        BoundedQueue queue = new BoundedQueueV6_0(2);

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

/* 생산자 먼저 실행

10.139 [     main] == [생산자 먼저 실행] 시작, BoundedQueueV6_0 ==

10.139 [     main] 생산자 시작
10.144 [producer1] [생산 시도] data1 -> []
10.144 [producer1] [생산 완료] data1 -> [data1]
10.250 [producer2] [생산 시도] data2 -> [data1]
10.250 [producer2] [생산 완료] data2 -> [data1, data2]
10.360 [producer3] [생산 시도] data3 -> [data1, data2]

10.469 [     main] 현재 상태 출력 - 큐 데이터: [data1, data2]
10.475 [     main] producer1:TERMINATED
10.475 [     main] producer2:TERMINATED
10.475 [     main] producer3:WAITING

10.475 [     main] 소비자 시작
10.476 [consumer1] [소비 시도]    ?    <- [data1, data2]
10.477 [consumer1] [소비 완료]  data1  <- [data2, data3]
10.477 [producer3] [생산 완료] data3 -> [data2, data3]
10.579 [consumer2] [소비 시도]    ?    <- [data2, data3]
10.579 [consumer2] [소비 완료]  data2  <- [data3]
10.688 [consumer3] [소비 시도]    ?    <- [data3]
10.689 [consumer3] [소비 완료]  data3  <- []

10.798 [     main] 현재 상태 출력 - 큐 데이터: []
10.799 [     main] producer1:TERMINATED
10.800 [     main] producer2:TERMINATED
10.800 [     main] producer3:TERMINATED
10.800 [     main] consumer1:TERMINATED
10.800 [     main] consumer2:TERMINATED
10.801 [     main] consumer3:TERMINATED
10.801 [     main] == [생산자 먼저 실행] 종료, BoundedQueueV6_0 ==

*/

/* 소비자 먼저 실행

    58.659 [     main] == [소비자 먼저 실행] 시작, BoundedQueueV6_0 ==

    58.660 [     main] 소비자 시작
    58.665 [consumer1] [소비 시도]    ?    <- []
    58.770 [consumer2] [소비 시도]    ?    <- []
    58.880 [consumer3] [소비 시도]    ?    <- []

    58.989 [     main] 현재 상태 출력 - 큐 데이터: []
    58.993 [     main] consumer1:WAITING
    58.993 [     main] consumer2:WAITING
    58.994 [     main] consumer3:WAITING

    58.994 [     main] 생산자 시작
    58.996 [producer1] [생산 시도] data1 -> []
    58.996 [producer1] [생산 완료] data1 -> [data1]
    58.996 [consumer1] [소비 완료]  data1  <- []
    59.099 [producer2] [생산 시도] data2 -> []
    59.100 [consumer2] [소비 완료]  data2  <- []
    59.100 [producer2] [생산 완료] data2 -> []
    59.209 [producer3] [생산 시도] data3 -> []
    59.209 [producer3] [생산 완료] data3 -> [data3]
    59.210 [consumer3] [소비 완료]  data3  <- []

    59.319 [     main] 현재 상태 출력 - 큐 데이터: []
    59.319 [     main] consumer1:TERMINATED
    59.319 [     main] consumer2:TERMINATED
    59.319 [     main] consumer3:TERMINATED
    59.320 [     main] producer1:TERMINATED
    59.320 [     main] producer2:TERMINATED
    59.320 [     main] producer3:TERMINATED
    59.320 [     main] == [소비자 먼저 실행] 종료, BoundedQueueV6_0 ==
 */


}
