package ch06producerconsumer.sub2lockcondition.step2seperation;

import ch06producerconsumer.BoundedQueue;
import ch06producerconsumer.ConsumerTask;
import ch06producerconsumer.ProducerTask;

import java.util.ArrayList;
import java.util.List;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BoundedMainV5 {
    public static void main(String[] args) {

        // 1. BoundedQueue 선택
        BoundedQueue queue = new BoundedQueueV5(2);

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

    35.255 [     main] == [생산자 먼저 실행] 시작, BoundedQueueV5 ==

    35.255 [     main] 생산자 시작
    35.262 [producer1] [생산 시도] data1 -> []
    35.262 [producer1] [put] 생산자 데이터 저장, consumerCond.signal() 호출
    35.262 [producer1] [생산 완료] data1 -> [data1]
    35.368 [producer2] [생산 시도] data2 -> [data1]
    35.368 [producer2] [put] 생산자 데이터 저장, consumerCond.signal() 호출
    35.369 [producer2] [생산 완료] data2 -> [data1, data2]
    35.478 [producer3] [생산 시도] data3 -> [data1, data2]
    35.478 [producer3] [put] 큐 포화상태, 생산자 대기: data3

    35.587 [     main] 현재 상태 출력 - 큐 데이터: [data1, data2]
    35.593 [     main] producer1:TERMINATED
    35.593 [     main] producer2:TERMINATED
    35.593 [     main] producer3:WAITING

    35.594 [     main] 소비자 시작
    35.595 [consumer1] [소비 시도]    ?    <- [data1, data2]
    35.595 [consumer1] [take] 소비자 데이터 획득, producerCond.signal() 호출
    35.595 [consumer1] [소비 완료]  data1  <- [data2]
    35.595 [producer3] [put] 생산자 깨어남
    35.596 [producer3] [put] 생산자 데이터 저장, consumerCond.signal() 호출
    35.596 [producer3] [생산 완료] data3 -> [data2, data3]
    35.696 [consumer2] [소비 시도]    ?    <- [data2, data3]
    35.697 [consumer2] [take] 소비자 데이터 획득, producerCond.signal() 호출
    35.697 [consumer2] [소비 완료]  data2  <- [data3]
    35.805 [consumer3] [소비 시도]    ?    <- [data3]
    35.805 [consumer3] [take] 소비자 데이터 획득, producerCond.signal() 호출
    35.806 [consumer3] [소비 완료]  data3  <- []

    35.914 [     main] 현재 상태 출력 - 큐 데이터: []
    35.914 [     main] producer1:TERMINATED
    35.914 [     main] producer2:TERMINATED
    35.915 [     main] producer3:TERMINATED
    35.915 [     main] consumer1:TERMINATED
    35.916 [     main] consumer2:TERMINATED
    35.916 [     main] consumer3:TERMINATED
    35.916 [     main] == [생산자 먼저 실행] 종료, BoundedQueueV5 ==

*/

/* 소비자 먼저 실행

    23.058 [     main] == [소비자 먼저 실행] 시작, BoundedQueueV5 ==

    23.058 [     main] 소비자 시작
    23.062 [consumer1] [소비 시도]    ?    <- []
    23.062 [consumer1] [take] 큐 공백상태 , 소비자 대기
    23.173 [consumer2] [소비 시도]    ?    <- []
    23.173 [consumer2] [take] 큐 공백상태 , 소비자 대기
    23.282 [consumer3] [소비 시도]    ?    <- []
    23.283 [consumer3] [take] 큐 공백상태 , 소비자 대기

    23.391 [     main] 현재 상태 출력 - 큐 데이터: []
    23.395 [     main] consumer1:WAITING
    23.396 [     main] consumer2:WAITING
    23.396 [     main] consumer3:WAITING

    23.396 [     main] 생산자 시작
    23.397 [producer1] [생산 시도] data1 -> []
    23.398 [producer1] [put] 생산자 데이터 저장, consumerCond.signal() 호출
    23.398 [consumer1] [put] 소비자 깨어남
    23.398 [producer1] [생산 완료] data1 -> [data1]
    23.398 [consumer1] [take] 소비자 데이터 획득, producerCond.signal() 호출
    23.398 [consumer1] [소비 완료]  data1  <- []
    23.499 [producer2] [생산 시도] data2 -> []
    23.499 [producer2] [put] 생산자 데이터 저장, consumerCond.signal() 호출
    23.500 [producer2] [생산 완료] data2 -> [data2]
    23.500 [consumer2] [put] 소비자 깨어남
    23.500 [consumer2] [take] 소비자 데이터 획득, producerCond.signal() 호출
    23.500 [consumer2] [소비 완료]  data2  <- []
    23.607 [producer3] [생산 시도] data3 -> []
    23.607 [producer3] [put] 생산자 데이터 저장, consumerCond.signal() 호출
    23.608 [consumer3] [put] 소비자 깨어남
    23.608 [producer3] [생산 완료] data3 -> [data3]
    23.608 [consumer3] [take] 소비자 데이터 획득, producerCond.signal() 호출
    23.608 [consumer3] [소비 완료]  data3  <- []

    23.717 [     main] 현재 상태 출력 - 큐 데이터: []
    23.718 [     main] consumer1:TERMINATED
    23.718 [     main] consumer2:TERMINATED
    23.719 [     main] consumer3:TERMINATED
    23.720 [     main] producer1:TERMINATED
    23.720 [     main] producer2:TERMINATED
    23.720 [     main] producer3:TERMINATED
    23.720 [     main] == [소비자 먼저 실행] 종료, BoundedQueueV5 ==
 */


/*
Object notify()
- 대기 중인 임의의 스레드 깨우기
- 꺠어나는 순서 보장 x (특별한 경우가 아니라면 기다렸던 순서이지만, JVM 구현 등에 따라 달라짐)
- synchronized 블록 내에서 "모니터락" 을 가지고 있는 스레드가 호출

Condition.signal()
- 특정 condition에 대기 중인 스레드를 깨우기 (버전과 구현에 따라 상이할 수는 있으나 기본은 Queue 사용하기때문에 선입선출)
- ReentrantLock 을 가진 스레드가 호출
*/

}
