package mission.week3.task4;


import mission.week3.task4.queue.BlockingQueueWrapper;
import mission.week3.task4.queue.ProducerConsumerQueue;
import mission.week3.task4.queue.ReentrantLockQueue;
import mission.week3.task4.queue.SynchronizedQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.IntStream;

// 41기 유도경
public class ProducerConsumerManager<T> {

    public static void main(String[] args) {

        // 큐의 포화/공핍 상태 명확한 발생을 위해 테스트 목적으로 큐 사이즈 1 설정
        ProducerConsumerQueue<String> synchronizedQueue = new SynchronizedQueue<>(1);
        ProducerConsumerQueue<String> reentrantLockQueue = new ReentrantLockQueue<>(1);
        ProducerConsumerQueue<String> blockingQueueWrapper = new BlockingQueueWrapper<>(1);

        Function<Integer, String> dataGenerator = String::valueOf;

        ProducerConsumerManager<String> manager1 = new ProducerConsumerManager<>(
                Executors.newFixedThreadPool(5),
                synchronizedQueue,
                dataGenerator
        );
        manager1.execute(10);

        ProducerConsumerManager<String> manager2 = new ProducerConsumerManager<>(
                Executors.newFixedThreadPool(5),
                reentrantLockQueue,
                dataGenerator
        );
        manager2.execute(10);

        ProducerConsumerManager<String> manager3 = new ProducerConsumerManager<>(
                Executors.newFixedThreadPool(5),
                blockingQueueWrapper,
                dataGenerator
        );
        manager3.execute(10);
    }


    private final ExecutorService executorService;
    private final ProducerConsumerQueue<T> queue;
    private final Function<Integer, T> dataGenerator;

    private int[][] checkedResults; // 단순 결과 체크용

    public ProducerConsumerManager(ExecutorService executorService, ProducerConsumerQueue<T> queue, Function<Integer, T> dataGenerator) {
        this.executorService = executorService;
        this.queue = queue;
        this.dataGenerator = dataGenerator;

    }

    // 작업 세팅
    private void execute(int taskNumber) { // 작업할 개수

        checkedResults = new int[taskNumber][2];

        System.out.printf("== [%s] 시작 ==\n",queue.getClass().getSimpleName());
        try (executorService) { // 풀의 스레드가 모두 작업 완료하거나, 지정시간이 끝날 때까지 대기 - 대기 후에는 자동 close()
            for (int i = 1; i <= taskNumber; i++) {
                producerProcess(i);
                consumerProcess();
            }
        } finally {
            printResults();
            System.out.printf("[%s] 프로그램 종료\n\n", Thread.currentThread().getName());
        }
    }

    private void printResults() {
        System.out.println("\n== 결과 출력 ==");
        IntStream.range(0, checkedResults.length)
                .forEach(idx -> {
                    System.out.printf("taskNum: %d - 생산: %d, 소비: %d\n", idx + 1, checkedResults[idx][0], checkedResults[idx][1]);
                });
        System.out.println();
    }

    private void producerProcess(int taskNumber) {
        T data = dataGenerator.apply(taskNumber);
        executorService.submit(() -> {
            queue.put(data);
            System.out.printf("[%s] 생산: %s\n", Thread.currentThread().getName(), data);
            checkedResults[taskNumber - 1][0] = 1; // 결과 체크
        });
    }


    private void consumerProcess() {

        executorService.submit(() -> {
                    T take = queue.take();
                    System.out.printf("[%s] 소비: %s\n", Thread.currentThread().getName(), take);

                    checkedResults[Integer.parseInt((String) take) - 1][1] = 1; // 결과 체크
                }
        );
    }
}
