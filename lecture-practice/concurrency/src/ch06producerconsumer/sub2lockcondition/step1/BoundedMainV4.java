package ch06producerconsumer.sub2lockcondition.step1;

import ch06producerconsumer.BoundedQueue;
import ch06producerconsumer.ConsumerTask;
import ch06producerconsumer.ProducerTask;

import java.util.ArrayList;
import java.util.List;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BoundedMainV4 {
    public static void main(String[] args) {

        // 1. BoundedQueue 선택
        BoundedQueue queue = new BoundedQueueV4(2);

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

    59.961 [     main] == [생산자 먼저 실행] 시작, BoundedQueueV4 ==

    59.962 [     main] 생산자 시작
    59.968 [producer1] [생산 시도] data1 -> []
    59.968 [producer1] [put] 생산자 데이터 저장, condition.signal() 호출
    59.970 [producer1] [생산 완료] data1 -> [data1]
    00.073 [producer2] [생산 시도] data2 -> [data1]
    00.073 [producer2] [put] 생산자 데이터 저장, condition.signal() 호출
    00.073 [producer2] [생산 완료] data2 -> [data1, data2]
    00.183 [producer3] [생산 시도] data3 -> [data1, data2]
    00.183 [producer3] [put] 큐 포화상태, 생산자 대기: data3

    00.292 [     main] 현재 상태 출력 - 큐 데이터: [data1, data2]
    00.300 [     main] producer1:TERMINATED
    00.300 [     main] producer2:TERMINATED
    00.300 [     main] producer3:WAITING

    00.300 [     main] 소비자 시작
    00.302 [consumer1] [소비 시도]    ?    <- [data1, data2]
    00.302 [consumer1] [take] 소비자 데이터 획득, condition.signal() 호출
    00.302 [consumer1] [소비 완료]  data1  <- [data2]
    00.302 [producer3] [put] 생산자 깨어남
    00.303 [producer3] [put] 생산자 데이터 저장, condition.signal() 호출
    00.303 [producer3] [생산 완료] data3 -> [data2, data3]
    00.403 [consumer2] [소비 시도]    ?    <- [data2, data3]
    00.403 [consumer2] [take] 소비자 데이터 획득, condition.signal() 호출
    00.403 [consumer2] [소비 완료]  data2  <- [data3]
    00.512 [consumer3] [소비 시도]    ?    <- [data3]
    00.512 [consumer3] [take] 소비자 데이터 획득, condition.signal() 호출
    00.513 [consumer3] [소비 완료]  data3  <- []

    00.622 [     main] 현재 상태 출력 - 큐 데이터: []
    00.622 [     main] producer1:TERMINATED
    00.623 [     main] producer2:TERMINATED
    00.623 [     main] producer3:TERMINATED
    00.623 [     main] consumer1:TERMINATED
    00.623 [     main] consumer2:TERMINATED
    00.623 [     main] consumer3:TERMINATED
    00.623 [     main] == [생산자 먼저 실행] 종료, BoundedQueueV4 ==

*/

/* 소비자 먼저 실행

    41.997 [     main] == [소비자 먼저 실행] 시작, BoundedQueueV4 ==

    41.998 [     main] 소비자 시작
    42.002 [consumer1] [소비 시도]    ?    <- []
    42.002 [consumer1] [take] 큐 공백상태 , 소비자 대기
    42.115 [consumer2] [소비 시도]    ?    <- []
    42.116 [consumer2] [take] 큐 공백상태 , 소비자 대기
    42.226 [consumer3] [소비 시도]    ?    <- []
    42.226 [consumer3] [take] 큐 공백상태 , 소비자 대기

    42.333 [     main] 현재 상태 출력 - 큐 데이터: []
    42.338 [     main] consumer1:WAITING
    42.338 [     main] consumer2:WAITING
    42.340 [     main] consumer3:WAITING

    42.340 [     main] 생산자 시작
    42.342 [producer1] [생산 시도] data1 -> []
    42.342 [producer1] [put] 생산자 데이터 저장, condition.signal() 호출
    42.342 [producer1] [생산 완료] data1 -> [data1]
    42.342 [consumer1] [put] 소비자 깨어남
    42.343 [consumer1] [take] 소비자 데이터 획득, condition.signal() 호출
    42.343 [consumer2] [put] 소비자 깨어남
    42.343 [consumer1] [소비 완료]  data1  <- []
    42.343 [consumer2] [take] 큐 공백상태 , 소비자 대기
    42.444 [producer2] [생산 시도] data2 -> []
    42.444 [producer2] [put] 생산자 데이터 저장, condition.signal() 호출
    42.444 [producer2] [생산 완료] data2 -> [data2]
    42.444 [consumer3] [put] 소비자 깨어남
    42.445 [consumer3] [take] 소비자 데이터 획득, condition.signal() 호출
    42.445 [consumer3] [소비 완료]  data2  <- []
    42.445 [consumer2] [put] 소비자 깨어남
    42.445 [consumer2] [take] 큐 공백상태 , 소비자 대기
    42.552 [producer3] [생산 시도] data3 -> []
    42.552 [producer3] [put] 생산자 데이터 저장, condition.signal() 호출
    42.554 [producer3] [생산 완료] data3 -> [data3]
    42.554 [consumer2] [put] 소비자 깨어남
    42.554 [consumer2] [take] 소비자 데이터 획득, condition.signal() 호출
    42.554 [consumer2] [소비 완료]  data3  <- []

    42.660 [     main] 현재 상태 출력 - 큐 데이터: []
    42.664 [     main] consumer1:TERMINATED
    42.664 [     main] consumer2:TERMINATED
    42.664 [     main] consumer3:TERMINATED
    42.664 [     main] producer1:TERMINATED
    42.664 [     main] producer2:TERMINATED
    42.664 [     main] producer3:TERMINATED
    42.665 [     main] == [소비자 먼저 실행] 종료, BoundedQueueV4 ==
 */


/*
아직 condition의 공간을 분리하지 않았기때문에 여전히 생산자, 소비자 비효율 문제 발생
*/

}
