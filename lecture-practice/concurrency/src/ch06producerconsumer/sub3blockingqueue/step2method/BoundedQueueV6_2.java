package ch06producerconsumer.sub3blockingqueue.step2method;

import ch06producerconsumer.BoundedQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static util.MyLogger.log;

// BlockingQueue - offer(E e, long timeout, TimeUnit unit), poll() -> 특정시간 대기
// pdf, 공식문서 보면서 복습
public class BoundedQueueV6_2 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueueV6_2(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {

        try {
            boolean result = queue.offer(data, 1, TimeUnit.NANOSECONDS); // 대기 시간 설정
            log("저장 시도 결과 = " + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public String take() {

        try {
            return queue.poll(2,TimeUnit.SECONDS);  // 대기 시간 설정
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
