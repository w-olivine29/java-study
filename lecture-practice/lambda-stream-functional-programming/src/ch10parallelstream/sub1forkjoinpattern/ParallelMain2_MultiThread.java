package ch10parallelstream.sub1forkjoinpattern;

import ch10parallelstream.HeavyJob;

import static ch10parallelstream.util.MyLogger.log;

// Fork/Join 패턴 - pdf 참고
public class ParallelMain2_MultiThread {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        // 1. Fork 작업 분할
        SumTask task1 = new SumTask(1, 4);
        SumTask task2 = new SumTask(5, 8);

        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");

        // 2. 분할 작업 처리
        thread1.start();
        thread2.start();

        // 3. 모든 스레드 작업 완료 후 ->  처리 결과 합치기
        thread1.join();
        thread2.join();
        log("main 스레드 대기 완료");

        int sum = task1.result + task2.result;


        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + sum); // 총 4초 소요
    }

    static class SumTask implements Runnable {

        int startValue;
        int endValue;
        int result = 0;


        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");

            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += HeavyJob.heavyTask(i);
            }
            result = sum;

            log(String.format("작업 완료 결과: %d", result));
        }
    }
}
