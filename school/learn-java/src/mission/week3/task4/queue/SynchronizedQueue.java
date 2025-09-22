package mission.week3.task4.queue;

import java.util.ArrayDeque;
import java.util.Queue;

// 41기 유도경
public class SynchronizedQueue<T> implements ProducerConsumerQueue<T> {

    private Queue<T> queue;
    private int maxSize;

    public SynchronizedQueue() {
        this.queue = new ArrayDeque<>();
        maxSize = 10;
    }

    public SynchronizedQueue(int maxSize) {
        this.queue = new ArrayDeque<>();
        this.maxSize = maxSize;
    }

    @Override
    public synchronized void put(T t) {
        waitForProduce();
        sleep(1000); // 데이터 생산 시 걸리는 시간으로 가정
        queue.offer(t);
        notify(); // wait 중인 스레드 깨우기
    }

    @Override
    public synchronized T take() {
        waitForConsume();
        sleep(300); // 데이터 소비 시 걸리는 시간으로 가정
        T take = queue.poll();
        notify(); // wait 중인 스레드 깨우기
        return take;
    }


    private synchronized void waitForProduce() {
        while (queue.size() >= maxSize) {
            System.out.printf("[%s] queue is full\n",
                    Thread.currentThread().getName());
            try {
                wait(); //다른 스레드가 notify 시 대기 상태 탈출
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private synchronized void waitForConsume() {
        while (queue.isEmpty()) {
            System.out.printf("[%s] queue is empty\n",
                    Thread.currentThread().getName());
            try {
                wait(); //다른 스레드가 notify 시 대기 상태 탈출
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
