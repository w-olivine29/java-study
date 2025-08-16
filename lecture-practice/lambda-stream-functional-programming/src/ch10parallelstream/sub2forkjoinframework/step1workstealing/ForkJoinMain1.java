package ch10parallelstream.sub2forkjoinframework.step1workstealing;

import ch10parallelstream.sub2forkjoinframework.SumTask;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static ch10parallelstream.util.MyLogger.log;

public class ForkJoinMain1 {
    public static void main(String[] args) {

        List<Integer> data = IntStream.rangeClosed(1, 8)
                .boxed()
                .toList();

        log("[생성]" + data);

        // ForkJoinPool 생성 & 작업 수행
        long startTime = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        SumTask task = new SumTask(data); //[1~8]

        // 병렬로 합을 구한 후 결과 출력
        Integer result = forkJoinPool.invoke(task);
        forkJoinPool.close();
        long endTime = System.currentTimeMillis();


        log("time: " + (endTime - startTime) + "ms, sum: " + result); // 총 2초 소요
        log("pool: " + forkJoinPool); //[Terminated, parallelism = 10, size = 0, active = 0, running = 0, steals = 4, tasks = 0, submissions = 0]

    }
}
