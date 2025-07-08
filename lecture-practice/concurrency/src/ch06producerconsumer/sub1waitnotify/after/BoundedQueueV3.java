package ch06producerconsumer.sub1waitnotify.after;

import ch06producerconsumer.BoundedQueue;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.log;

// wait(), notify() 적용
// pdf - 작동원리 복습 필수
public class BoundedQueueV3 implements BoundedQueue {

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV3(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        while (queue.size() >= max) {
            log("[put] 큐 포화상태, 생산자 대기: " + data);

            try {

                //RUNNABLE -> WAITING (락 반납하고 임계영역 내의 대기집합에서 대기, notify()를 통해 깨어날 수 있음)
                wait();
                log("[put] 생산자 깨어남");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        queue.offer(data);
        log("[put] 생산자 데이터 저장, notify() 호출");
        notify();  // WAITING 상태 스레드 -> BLOCKED (깨어나서 대기집합에서 나감 -> 락을 획득하기 위해 BLOCKED 상태로 대기) -> RUNNABLE (lock 획득)

    }

    @Override
    public synchronized String take() {
        while (queue.isEmpty()) {
            log("[take] 큐 공백상태 , 소비자 대기");
            try {

                //RUNNABLE -> WAITING (락 반납하고 임계영역 내의 대기집합에서 대기, notify()를 통해 깨어날 수 있음)
                wait();
                log("[put] 소비자 깨어남");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String data = queue.poll();
        log("[take] 소비자 데이터 획득, notify() 호출");
        notify(); // WAITING 상태 스레드 -> BLOCKED (깨어나서 대기집합에서 나감 -> 락을 획득하기 위해 BLOCKED 상태로 대기) -> RUNNABLE (lock 획득)

        return data;
    }

    @Override
    public String toString() { // 원래는 해당 메서드도 synchronized 걸어줘야하나 예제 단순화를 위해 제외
        return queue.toString();
    }
}
