package ch06producerconsumer;

import static util.MyLogger.log;

public class ConsumerTask implements Runnable {

    private BoundedQueue queue;

    public ConsumerTask(BoundedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        log(String.format("[소비 시도]    ?    <- %s", queue));

        String data = queue.take();
        log(String.format("[소비 완료]  %5s  <- %s", data, queue));
    }
}
