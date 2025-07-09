package ch06producerconsumer.sub3blockingqueue.step2method;

import ch06producerconsumer.BoundedQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static util.MyLogger.log;

// BlockingQueue - offer(), poll() -> 스레드 대기x
// pdf, 공식문서 보면서 복습
public class BoundedQueueV6_1 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueueV6_1(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {
        boolean result = queue.offer(data); //바로 결과를 반환 (true of false)
        log("저장 시도 결과 = " + result);

    }

    @Override
    public String take() {
        //바로 결과를 반환 (데이터 or null)
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
