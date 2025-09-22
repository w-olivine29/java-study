package mission.week3.task4.queue;


// 41기 유도경
public interface ProducerConsumerQueue<T> {

    void put(T t);

    T take();


    default void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
