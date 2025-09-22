package mission.week3.task4.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// 41기 유도경
public class BlockingQueueWrapper<T> implements ProducerConsumerQueue<T> {

    private final BlockingQueue<T> blockingQueue;

    public BlockingQueueWrapper(int maxSize) {
        this.blockingQueue = new ArrayBlockingQueue<>(maxSize);
    }

    // put & take ->  자동 대기 기능 (내부적으로 알아서 반복 대기)
    @Override
    public void put(T t) {
        try {
            blockingQueue.put(t);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T take() {
        try {
            return blockingQueue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
