package ch06producerconsumer.sub2lockcondition.step1;

import ch06producerconsumer.BoundedQueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;

// ReentrantLock 적용
public class BoundedQueueV4 implements BoundedQueue {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition(); // 스레드 대기 집합 (wait() 에서 사용하는 스레드 대기 공간x)

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV4(int max) {
        this.max = max;
    }

    @Override
    public void put(String data) {

        lock.lock();
        try {
            while (queue.size() >= max) {
                log("[put] 큐 포화상태, 생산자 대기: " + data);

                try {
                    condition.await(); // 지정한 condition 에 현재 스레드를 WAITING 상태로 보관
                    log("[put] 생산자 깨어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            queue.offer(data);
            log("[put] 생산자 데이터 저장, condition.signal() 호출");

            condition.signal();

        } finally {
            lock.unlock();
        }


    }

    @Override
    public String take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                log("[take] 큐 공백상태 , 소비자 대기");
                try {
                    condition.await(); // 지정한 condition 에 현재 스레드를 WAITING 상태로 보관
                    log("[put] 소비자 깨어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String data = queue.poll();
            log("[take] 소비자 데이터 획득, condition.signal() 호출");
            condition.signal();
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
