package ch06producerconsumer;

import static util.MyLogger.log;

public class ProducerTask implements Runnable {

    private BoundedQueue queue;
    private String request;

    public ProducerTask(BoundedQueue queue, String request) {
        this.queue = queue;
        this.request = request;
    }

    @Override
    public void run() {
        log(String.format("[생산 시도] %s -> %s", request, queue));
        queue.put(request);

        log(String.format("[생산 완료] %s -> %s", request, queue));
    }
}
