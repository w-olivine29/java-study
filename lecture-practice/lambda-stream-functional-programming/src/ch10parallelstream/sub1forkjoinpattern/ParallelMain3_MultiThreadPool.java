package ch10parallelstream.sub1forkjoinpattern;

import ch10parallelstream.HeavyJob;

import java.util.concurrent.*;

import static ch10parallelstream.util.MyLogger.log;

// Fork/Join 패턴 - pdf 참고
public class ParallelMain3_MultiThreadPool {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();

        // 1. 스레드 풀 준비
        ExecutorService es = Executors.newFixedThreadPool(2);

        // 2. Fork 작업 분할
        SumTask task1 = new SumTask(1, 4);
        SumTask task2 = new SumTask(5, 8);
        
        // 3. 분할작업 처리
        // 미래 결과값을 가져올 수 있는 Future 반환
        Future<Integer> future1 = es.submit(task1);
        Future<Integer> future2 = es.submit(task2);

        // 4. 모든 스레드 작업 완료 후 ->  처리 결과 합치기
        // get()은 실제 결과값이 나올 때까지 대기 (블로킹 메서드)
        Integer result1 = future1.get();
        Integer result2 = future2.get();
        log("main 스레드 대기 완료");

        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + (result1 + result2)); // 총 4초 소요

        es.close();
    }

    static class SumTask implements Callable<Integer> {

        int startValue;
        int endValue;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public Integer call() {
            log("작업 시작");

            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += HeavyJob.heavyTask(i);
            }

            log(String.format("작업 완료 결과: %d", sum));
            return sum;
        }
    }
}
