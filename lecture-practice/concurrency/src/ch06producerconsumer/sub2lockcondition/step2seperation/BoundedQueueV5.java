package ch06producerconsumer.sub2lockcondition.step2seperation;

import ch06producerconsumer.BoundedQueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;

// ReentrantLock 적용
public class BoundedQueueV5 implements BoundedQueue {

    private final Lock lock = new ReentrantLock();
    
    // ReentrantLock 을 사용하는 스레드 대기 공간
    private final Condition producerCond = lock.newCondition(); // 생산자 스레드 대기 집합
    private final Condition consumerCond = lock.newCondition(); // 소비자 스레드 대기 집합

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV5(int max) {
        this.max = max;
    }

    
    // 생산자 스레드가 수행하는 메서드
    // producerCond 에서 대기
    // 수행 후 ConsumerCond 에서 대기 중인 소비자 스레드를 깨움
    @Override
    public void put(String data) {

        lock.lock();
        try {
            while (queue.size() >= max) {
                log("[put] 큐 포화상태, 생산자 대기: " + data);

                try {
                    producerCond.await(); // 지정한 condition 에 현재 스레드를 WAITING 상태로 보관
                    log("[put] 생산자 깨어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            queue.offer(data);
            log("[put] 생산자 데이터 저장, consumerCond.signal() 호출");
            consumerCond.signal(); // 지정한 condition 의 스레드를 깨움

        } finally {
            lock.unlock();
        }


    }

    // 소비자 스레드가 수행하는 메서드
    // consumerCond 에서 대기
    // 수행 후 ProducerCond 에서 대기 중인 생산자 스레드를 깨움
    @Override
    public String take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                log("[take] 큐 공백상태 , 소비자 대기");
                try {
                    consumerCond.await(); // 지정한 condition 에 현재 스레드를 WAITING 상태로 보관
                    log("[put] 소비자 깨어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String data = queue.poll();
            log("[take] 소비자 데이터 획득, producerCond.signal() 호출");
            producerCond.signal(); // 지정한 condition 의 스레드를 깨움
            return data;
        } finally {
            lock.unlock();

        }
    }

    @Override
    public String toString() { // 원래는 해당 메서드도 synchronized 걸어줘야하나 예제 단순화를 위해 제외
        return queue.toString();
    }
}
