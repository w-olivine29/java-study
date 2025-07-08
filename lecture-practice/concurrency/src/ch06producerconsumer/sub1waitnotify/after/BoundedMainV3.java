package ch06producerconsumer.sub1waitnotify.after;

import ch06producerconsumer.BoundedQueue;
import ch06producerconsumer.ConsumerTask;
import ch06producerconsumer.ProducerTask;

import java.util.ArrayList;
import java.util.List;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BoundedMainV3 {
    public static void main(String[] args) {

        // 1. BoundedQueue 선택
        BoundedQueue queue = new BoundedQueueV3(2);

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

    42.610 [     main] == [생산자 먼저 실행] 시작, BoundedQueueV3 ==

    42.611 [     main] 생산자 시작
    42.616 [producer1] [생산 시도] data1 -> []
    42.616 [producer1] [put] 생산자 데이터 저장, notify() 호출
    42.616 [producer1] [생산 완료] data1 -> [data1]
    42.725 [producer2] [생산 시도] data2 -> [data1]
    42.725 [producer2] [put] 생산자 데이터 저장, notify() 호출
    42.725 [producer2] [생산 완료] data2 -> [data1, data2]
    42.837 [producer3] [생산 시도] data3 -> [data1, data2]
    42.837 [producer3] [put] 큐 포화상태, 생산자 대기: data3

    42.947 [     main] 현재 상태 출력 - 큐 데이터: [data1, data2]
    42.954 [     main] producer1:TERMINATED
    42.954 [     main] producer2:TERMINATED
    42.954 [     main] producer3:WAITING

    42.955 [     main] 소비자 시작
    42.957 [consumer1] [소비 시도]    ?    <- [data1, data2]
    42.957 [consumer1] [take] 소비자 데이터 획득, notify() 호출
    42.957 [producer3] [put] 생산자 깨어남
    42.957 [consumer1] [소비 완료]  data1  <- [data2]
    42.957 [producer3] [put] 생산자 데이터 저장, notify() 호출
    42.957 [producer3] [생산 완료] data3 -> [data2, data3]
    43.058 [consumer2] [소비 시도]    ?    <- [data2, data3]
    43.059 [consumer2] [take] 소비자 데이터 획득, notify() 호출
    43.059 [consumer2] [소비 완료]  data2  <- [data3]
    43.167 [consumer3] [소비 시도]    ?    <- [data3]
    43.167 [consumer3] [take] 소비자 데이터 획득, notify() 호출
    43.167 [consumer3] [소비 완료]  data3  <- []

    43.277 [     main] 현재 상태 출력 - 큐 데이터: []
    43.277 [     main] producer1:TERMINATED
    43.277 [     main] producer2:TERMINATED
    43.277 [     main] producer3:TERMINATED
    43.279 [     main] consumer1:TERMINATED
    43.279 [     main] consumer2:TERMINATED
    43.279 [     main] consumer3:TERMINATED
    43.280 [     main] == [생산자 먼저 실행] 종료, BoundedQueueV3 ==
*/

/* 소비자 먼저 실행

    11.855 [     main] == [소비자 먼저 실행] 시작, BoundedQueueV3 ==

    11.856 [     main] 소비자 시작
    11.861 [consumer1] [소비 시도]    ?    <- []
    11.861 [consumer1] [take] 큐 공백상태 , 소비자 대기
    11.976 [consumer2] [소비 시도]    ?    <- []
    11.976 [consumer2] [take] 큐 공백상태 , 소비자 대기
    12.087 [consumer3] [소비 시도]    ?    <- []
    12.087 [consumer3] [take] 큐 공백상태 , 소비자 대기

    12.196 [     main] 현재 상태 출력 - 큐 데이터: []
    12.201 [     main] consumer1:WAITING
    12.201 [     main] consumer2:WAITING
    12.201 [     main] consumer3:WAITING

    12.201 [     main] 생산자 시작
    12.205 [producer1] [생산 시도] data1 -> []
    12.205 [producer1] [put] 생산자 데이터 저장, notify() 호출
    12.205 [producer1] [생산 완료] data1 -> [data1]
    12.205 [consumer1] [put] 소비자 깨어남
    12.206 [consumer1] [take] 소비자 데이터 획득, notify() 호출
    12.206 [consumer1] [소비 완료]  data1  <- []

    12.206 [consumer2] [put] 소비자 깨어남
    12.206 [consumer2] [take] 큐 공백상태 , 소비자 대기    => CPU 자원만 소모하고, 다시 대기 집합에 들어간 상황 (비효율적)

    12.306 [producer2] [생산 시도] data2 -> []
    12.307 [producer2] [put] 생산자 데이터 저장, notify() 호출
    12.307 [consumer3] [put] 소비자 깨어남
    12.307 [producer2] [생산 완료] data2 -> [data2]
    12.307 [consumer3] [take] 소비자 데이터 획득, notify() 호출
    12.307 [consumer2] [put] 소비자 깨어남
    12.307 [consumer3] [소비 완료]  data2  <- []
    12.307 [consumer2] [take] 큐 공백상태 , 소비자 대기
    12.418 [producer3] [생산 시도] data3 -> []
    12.418 [producer3] [put] 생산자 데이터 저장, notify() 호출
    12.418 [producer3] [생산 완료] data3 -> [data3]
    12.418 [consumer2] [put] 소비자 깨어남
    12.419 [consumer2] [take] 소비자 데이터 획득, notify() 호출
    12.419 [consumer2] [소비 완료]  data3  <- []

    12.527 [     main] 현재 상태 출력 - 큐 데이터: []
    12.527 [     main] consumer1:TERMINATED
    12.528 [     main] consumer2:TERMINATED
    12.528 [     main] consumer3:TERMINATED
    12.528 [     main] producer1:TERMINATED
    12.528 [     main] producer2:TERMINATED
    12.528 [     main] producer3:TERMINATED
    12.528 [     main] == [소비자 먼저 실행] 종료, BoundedQueueV3 ==
 */


/*
wait(), notify()의 한계

1. 스레드 대기 집합 문제
  - 하나의 객체에 하나의 대기 큐만 존재
  - 생산자/소비자 스레드를 구분해서 깨울 수 없음
  -> 같은 종류의 스레드를 깨우는 경우 비효율 발생

2. 임의 스레드 선택 문제
  - notify()는 "임의의 스레드" 하나를 선택해서 깨움
  - 이론적으로 스레드 기아 현상 발생 가능
  - notifyAll()로 어느정도 해결 가능하지만 비효율 문제는 여전함

3. 실제 구현에서의 완화
  - 특별한 상황이 아니면 오래 기다린 스레드를 우선적으로 깨우는 로직 구현돼있음
  - 먼저 기다렸던 스레드가 먼저 실행될 가능성이 높음 (완전한 순서 보장은 아님, JVM 구현에 따라 다름)

4. 해결책
  - Lock과 Condition 사용으로 생산자/소비자 문제 해결
  - 생산자 전용 대기 큐와 소비자 전용 대기 큐 분리 가능
  - 정교한 스레드 제어 및 성능 향상
*/

}
