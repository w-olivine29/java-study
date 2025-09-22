package mission.week3.task4.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//41기 유도경
public class ReentrantLockQueue<T> implements ProducerConsumerQueue<T> {

    private Queue<T> queue;
    private int maxSize;

    private final ReentrantLock lock;

    // ReentrantLock 사용하는 스레드 대기 공간 분리
    private final Condition producerCondition;
    private final Condition consumerCondition;


    public ReentrantLockQueue(int maxSize) {
        this.queue = new ArrayDeque<>();
        this.maxSize = maxSize;
        this.lock = new ReentrantLock();

        this.producerCondition = lock.newCondition();
        this.consumerCondition = lock.newCondition();
    }

    @Override
    public void put(T t) {
        try {
            lock.lock();

            waitForProduce();
            sleep(1000); // 데이터 생산 시 걸리는 시간으로 가정
            queue.offer(t);
            consumerCondition.signal(); // 생산 후 대기중인 소비자스레드 꺠우기
        } finally {
            lock.unlock();
        }
    }

    @Override
    public T take() {
        try{
            lock.lock();

            waitForConsume();
            sleep(300); // 데이터 소비 시 걸리는 시간으로 가정
            T take = queue.poll();
            producerCondition.signal(); // 소비 후 대기중인 생산자스레드 깨우기
            return take;
        }finally {
            lock.unlock();
        }
    }

    private void waitForProduce() {
        while (queue.size() >= maxSize) {
            System.out.printf("[%s] queue is full\n",
                    Thread.currentThread().getName());
            try {
                producerCondition.await(); // 해당 컨디션에 signal 시 꺠어남
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void waitForConsume() {
        while (queue.isEmpty()) {
            System.out.printf("[%s] queue is empty\n",
                    Thread.currentThread().getName());
            try {
                consumerCondition.await();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
