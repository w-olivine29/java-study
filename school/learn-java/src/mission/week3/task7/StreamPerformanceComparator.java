package mission.week3.task7;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.LongStream;


// 41기 유도경
public class StreamPerformanceComparator {
    public static void main(String[] args) {

        long taskAmount1 = 500_000_000L;
        System.out.println("== LongStream ==");
        executeAndReport(taskAmount1, false, true);
        executeAndReport(taskAmount1, true, true);


        System.out.println("== Stream<Long> ==");
        executeAndReport(taskAmount1, false, false);
        executeAndReport(taskAmount1, true, false);

    }

    private static void executeAndReport(long taskAmount, boolean isParallel, boolean usePrimitiveType) {

        long startTime = System.currentTimeMillis();

        Long result = getStreamSupplier(taskAmount, isParallel, usePrimitiveType).get();

        long endTime = System.currentTimeMillis();

        System.out.printf("%s 스트림 합계: %d (시간: %dms)\n",
                (isParallel ? "병렬" : "순차"), result, (endTime - startTime));
    }


    private static Supplier<Long> getStreamSupplier(long taskAmount, boolean isParallel, boolean usePrimitiveType) {
        if (usePrimitiveType) {
            return isParallel ? getParallelSupplierFromPrimitive(taskAmount) : getSequentialSupplierFromPrimitive(taskAmount);

        } else {
            List<Long> list = LongStream.rangeClosed(0, taskAmount)
                    .boxed()
                    .toList();

            return isParallel ? getParallelSupplier(list) : getSequentialSupplier(list);
        }
    }

    private static Supplier<Long> getSequentialSupplierFromPrimitive(long taskAmount) {
        return () -> LongStream.rangeClosed(0, taskAmount).sum();
    }

    private static Supplier<Long> getParallelSupplierFromPrimitive(long taskAmount) {
        return () -> LongStream.rangeClosed(0, taskAmount)
                .parallel().sum();
    }


    private static Supplier<Long> getSequentialSupplier(List<Long> sourceNumbers) {
        return () -> sourceNumbers.stream()
                .mapToLong(Long::valueOf)
                .sum();
    }

    private static Supplier<Long> getParallelSupplier(List<Long> sourceNumbers) {
        return () -> sourceNumbers.parallelStream()
                .mapToLong(Long::valueOf)
                .sum();
    }

}
/* 결과
== LongStream ==
순차 스트림 합계: 125000000250000000 (시간: 830ms)
병렬 스트림 합계: 125000000250000000 (시간: 20ms)


== Stream<Long> ==   (-Xmx20g 설정으로 겨우 실행)
순차 스트림 합계: 125000000250000000 (시간: 58964ms)
병렬 스트림 합계: 125000000250000000 (시간: 57621ms)
*/