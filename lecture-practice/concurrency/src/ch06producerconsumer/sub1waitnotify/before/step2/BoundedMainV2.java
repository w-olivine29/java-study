package ch06producerconsumer.sub1waitnotify.before.step2;

import ch06producerconsumer.BoundedQueue;
import ch06producerconsumer.ConsumerTask;
import ch06producerconsumer.ProducerTask;

import java.util.ArrayList;
import java.util.List;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BoundedMainV2 {
    public static void main(String[] args) {

        // 1. BoundedQueue 선택
        BoundedQueue queue = new BoundedQueueV2(2);

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

    13.785 [     main] == [생산자 먼저 실행] 시작, BoundedQueueV2 ==

    13.785 [     main] 생산자 시작
    13.789 [producer1] [생산 시도] data1 -> []
    13.790 [producer1] [생산 완료] data1 -> [data1]
    13.904 [producer2] [생산 시도] data2 -> [data1]
    13.904 [producer2] [생산 완료] data2 -> [data1, data2]
    14.012 [producer3] [생산 시도] data3 -> [data1, data2]
    14.013 [producer3] [put] 큐 포화상태, 생산자 대기: data3

    14.122 [     main] 현재 상태 출력 - 큐 데이터: [data1, data2]
    14.127 [     main] producer1:TERMINATED
    14.127 [     main] producer2:TERMINATED
    14.127 [     main] producer3:TIMED_WAITING

    14.127 [     main] 소비자 시작
    14.129 [consumer1] [소비 시도]    ?    <- [data1, data2]
    14.232 [consumer2] [소비 시도]    ?    <- [data1, data2]
    14.333 [consumer3] [소비 시도]    ?    <- [data1, data2]

    14.433 [     main] 현재 상태 출력 - 큐 데이터: [data1, data2]
    14.433 [     main] producer1:TERMINATED
    14.433 [     main] producer2:TERMINATED
    14.433 [     main] producer3:TIMED_WAITING
    14.433 [     main] consumer1:BLOCKED
    14.433 [     main] consumer2:BLOCKED
    14.434 [     main] consumer3:BLOCKED
    14.434 [     main] == [생산자 먼저 실행] 종료, BoundedQueueV2 ==

    15.021 [producer3] [put] 큐 포화상태, 생산자 대기: data3
    16.030 [producer3] [put] 큐 포화상태, 생산자 대기: data3
    17.040 [producer3] [put] 큐 포화상태, 생산자 대기: data3
    18.042 [producer3] [put] 큐 포화상태, 생산자 대기: data3
    19.047 [producer3] [put] 큐 포화상태, 생산자 대기: data3
    .... 무한실행


    producer3 스레드가 lock를 가진 상태에서 큐에 빈 자리가 나올 때까지 대기 -> consumer 스레드들은 BLOCKED -> 무한대기
*/

/* 소비자 먼저 실행

    54.279 [     main] == [소비자 먼저 실행] 시작, BoundedQueueV2 ==

    54.280 [     main] 소비자 시작
    54.285 [consumer1] [소비 시도]    ?    <- []
    54.285 [consumer1] [take] 큐 공백상태 , 소비자 대기
    54.390 [consumer2] [소비 시도]    ?    <- []
    54.498 [consumer3] [소비 시도]    ?    <- []

    54.599 [     main] 현재 상태 출력 - 큐 데이터: []
    54.603 [     main] consumer1:TIMED_WAITING
    54.603 [     main] consumer2:BLOCKED
    54.603 [     main] consumer3:BLOCKED

    54.603 [     main] 생산자 시작
    54.604 [producer1] [생산 시도] data1 -> []
    54.706 [producer2] [생산 시도] data2 -> []
    54.806 [producer3] [생산 시도] data3 -> []

    54.906 [     main] 현재 상태 출력 - 큐 데이터: []
    54.906 [     main] consumer1:TIMED_WAITING
    54.906 [     main] consumer2:BLOCKED
    54.906 [     main] consumer3:BLOCKED
    54.907 [     main] producer1:BLOCKED
    54.907 [     main] producer2:BLOCKED
    54.907 [     main] producer3:BLOCKED
    54.907 [     main] == [소비자 먼저 실행] 종료, BoundedQueueV2 ==
    55.289 [consumer1] [take] 큐 공백상태 , 소비자 대기
    56.296 [consumer1] [take] 큐 공백상태 , 소비자 대기
    57.299 [consumer1] [take] 큐 공백상태 , 소비자 대기
    58.304 [consumer1] [take] 큐 공백상태 , 소비자 대기
    59.312 [consumer1] [take] 큐 공백상태 , 소비자 대기
    ... 무한반복

    consumer1 스레드가 lock를 가지고 있는 상태로 큐에 데이터가 들어올때까지 대기 -> producer 들은 BLOCKED -> 무한 대기
 */


/* 

next step) lock를 가지고 대기하는 스레드가 대기하는 동안 다른 스레드에게 lock을 양보할 수 있게 하자
    ->  Object.wait(), Object.notify()
*/

}
