package ch10parallelstream.sub1forkjoinpattern;

import ch10parallelstream.HeavyJob;

import java.util.stream.IntStream;

import static ch10parallelstream.util.MyLogger.*;

// 하나의 메인스레드로 계산
public class ParallelMain1_SingleThread {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 10)
                .map(HeavyJob::heavyTask)
                .reduce(0, (a, b) -> a + b); //sum();

        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + sum); // 총 10초 소요

    }
}
