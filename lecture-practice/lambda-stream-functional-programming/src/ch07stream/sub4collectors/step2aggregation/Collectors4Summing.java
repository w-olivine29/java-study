package ch07stream.sub4collectors.step2aggregation;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collectors4Summing {
    public static void main(String[] args) {

        // 다운스트림 컬렉터에서 유용하게 사용
        Long count1 = Stream.of(1, 2, 3)
                .collect(Collectors.counting());
        System.out.println("count1 = " + count1); // 3

        // =======================================================================
        long count2 = Stream.of(1, 2, 3)
                .count();
        System.out.println("count2 = " + count2); // 3

        // =======================================================================
        Double average1 = Stream.of(1, 2, 3)
                .collect(Collectors.averagingInt(num -> num));

        //  기본형 특화 스트림으로 변환 =======================================================================
        double average2 = Stream.of(1, 2, 3)
                .mapToInt(num -> num) //IntStream 반환
                .average() //OptionalDouble
                .getAsDouble();
        System.out.println("average2 = " + average2);

        // 기본형 특화 스트림 사용 =======================================================================
        double average3 = IntStream.of(1, 2, 3)
                .average() //OptionalDouble
                .getAsDouble();
        System.out.println("average3 = " + average3);

        // 통계 =======================================================================
        IntSummaryStatistics statistics = Stream.of("Brie", "Camembert", "Cream cheese", "Ricotta")
                .collect(Collectors.summarizingInt(String::length));//ToIntFunction<? super T> mapper

        System.out.println("statistics.getSum() = " + statistics.getSum());
        System.out.println("statistics.getCount() = " + statistics.getCount());
        System.out.println("statistics.getAverage() = " + statistics.getAverage());
        System.out.println("statistics.getMin() = " + statistics.getMin());
        System.out.println("statistics.getMax() = " + statistics.getMax());
    }
}
