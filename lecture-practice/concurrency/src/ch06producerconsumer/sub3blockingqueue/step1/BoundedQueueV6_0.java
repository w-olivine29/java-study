package ch06producerconsumer.sub3blockingqueue.step1;

import ch06producerconsumer.BoundedQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// BlockingQueue 적용
// pdf, 구현체의 put, take 내부 살펴보면서 복습
public class BoundedQueueV6_0 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueueV6_0(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {
        try {
            queue.put(data);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String take() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
