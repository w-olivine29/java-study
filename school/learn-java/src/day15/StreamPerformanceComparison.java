package day15;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.LongStream;

public class StreamPerformanceComparison {
    public static void main(String[] args) {

        List<Long> list = LongStream.rangeClosed(0, 100_000_000L)
                .boxed() // Stream<Long>
                .toList();

        System.out.println("=== 순차적 처리 ===");

        withRequiredTime(taskAmount -> { // 기본타입 스트림, reduce 써보려고 짠 코드

            System.out.println("순차적 처리 - LongStream - reduce");
            long result = LongStream.rangeClosed(0, taskAmount)
                    .reduce((left, right) -> {
                        if (right % 2 == 0) {
                            return left + right;
                        }
                        return left;
                    }).orElse(0);

            System.out.println("result = " + result);
        }, 100_000_000L);
        System.out.println();


        withRequiredTime(taskAmount -> {
            System.out.println("순차적 처리 - LongStream - filter, sum");
            long result = LongStream.rangeClosed(0, taskAmount)
                    .filter(num -> num % 2 == 0)
                    .sum();

            System.out.println("result = " + result);
        }, 100_000_000L);
        System.out.println();


        withRequiredTime(taskAmount -> {
            System.out.println("순차적 처리 - Stream<Long> - reduce");
            long result = list.stream()
                    .reduce((left, right) -> {
                        if (right % 2 == 0) {
                            return left + right;
                        }
                        return left;
                    }).orElse(0L);
            System.out.println("result = " + result);
        }, 100_000_000L);
        System.out.println();


        withRequiredTime(taskAmount -> {
            System.out.println("순차적 처리 - Stream<Long> - filter, mapToLong, sum");
            long result = list.stream()
                    .filter(num -> num % 2 == 0)
                    .mapToLong(Long::valueOf)
                    .sum();

            System.out.println("result = " + result);
        }, 100_000_000L);
        System.out.println();


        System.out.println("=== 병렬 처리 ===");

        withRequiredTime(taskAmount -> {
            System.out.println("병렬 처리 - Stream<Long> - reduce");
            long result = list.parallelStream()
                    .reduce((left, right) -> {
                        if (right % 2 == 0) {
                            return left + right;
                        }
                        return left;
                    }).orElse(0L);
            System.out.println("result = " + result);
        }, 100_000_000L);
        System.out.println();


        withRequiredTime(taskAmount -> {

            System.out.println("병렬 처리 - Stream<Long> - filter, mapToLong, sum");
            long result = list.parallelStream()
                    .filter(num -> num % 2 == 0)
                    .mapToLong(Long::valueOf)
                    .sum();

            System.out.println("result = " + result);
        }, 100_000_000L);

    }


    private static void withRequiredTime(Consumer<Long> consumer, long taskAmount) {

        long startTime = System.currentTimeMillis();
        consumer.accept(taskAmount);
        long endTime = System.currentTimeMillis();

        System.out.println("소요시간: " + (endTime - startTime) + "ms");
    }
}


/* 실행결과 속도차이
 [기본형 특화 스트림] reduce > (filter & mapToX & sum)
 [스트림] reduce < (filter & mapToX & sum)

 동일한 로직이라면 병렬스트림이 더 빠름
*/


/*
=== 순차적 처리 ===
순차적 처리 - LongStream - reduce
result = 2500000050000000
소요시간: 94ms

순차적 처리 - LongStream - filter, sum
result = 2500000050000000
소요시간: 230ms

순차적 처리 - Stream<Long> - reduce
result = 2500000050000000
소요시간: 842ms

순차적 처리 - Stream<Long> - filter, mapToLong, sum
result = 2500000050000000
소요시간: 314ms

=== 병렬 처리 ===
병렬 처리 - Stream<Long> - reduce
result = 2500000050000000
소요시간: 348ms

병렬 처리 - Stream<Long> - filter, mapToLong, sum
result2 = 2500000050000000
소요시간: 195ms

*/