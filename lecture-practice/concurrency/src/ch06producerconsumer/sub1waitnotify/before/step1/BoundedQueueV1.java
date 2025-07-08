package ch06producerconsumer.sub1waitnotify.before.step1;

import ch06producerconsumer.BoundedQueue;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.log;

// 큐 조건 체크 후 조건 불만족 시 대기 x
public class BoundedQueueV1 implements BoundedQueue {

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV1(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        if (queue.size() >= max) {
            log("[put] 큐 포화상태, 데이터버림: " + data);
            return;
        }
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    @Override
    public String toString() { // 원래는 해당 메서드도 synchronized 걸어줘야하나 예제 단순화를 위해 제외
        return queue.toString();
    }
}
