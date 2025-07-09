package ch06producerconsumer.sub3blockingqueue.step2method;

import ch06producerconsumer.BoundedQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static util.MyLogger.log;

// BlockingQueue - add(), remove() -> true or  IllegalStateException, NoSuchElementException
// pdf, 공식문서 보면서 복습
public class BoundedQueueV6_3 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueueV6_3(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {
        log("저장 시도 결과 = " + queue.add(data)); // IllegalStateException :Queue full
    }

    @Override
    public String take() {
        return queue.remove(); // NoSuchElementException
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
