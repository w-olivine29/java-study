package ch06producerconsumer.sub1waitnotify.before.step2;

import ch06producerconsumer.BoundedQueue;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

// 큐 상태 체크 -> 조건 만족할 때까지 대기
public class BoundedQueueV2 implements BoundedQueue {

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV2(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        while (queue.size() >= max) {
            log("[put] 큐 포화상태, 생산자 대기: " + data);
            sleep(1000);
        }
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        while (queue.isEmpty()) {
            log("[take] 큐 공백상태 , 소비자 대기");
            sleep(1000);
        }
        return queue.poll();
    }

    @Override
    public String toString() { // 원래는 해당 메서드도 synchronized 걸어줘야하나 예제 단순화를 위해 제외
        return queue.toString();
    }
}
