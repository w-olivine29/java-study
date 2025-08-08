package ch07stream.sub3operation.step4primitivespecialized;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamMain {
    public static void main(String[] args) {

        System.out.println("\n================================================================================");
        // 기본형 특화 스트림 생성(IntStream, LongStream, DoubleStream)
        IntStream stream = IntStream.of(1, 2, 3, 4, 5);
        stream.forEach(i -> System.out.print(i + " "));
        System.out.println();

        System.out.println("\n================================================================================");
        // 범위 생성 메서드 (IntStream, LongStream)
        IntStream range1 = IntStream.range(1, 5); // [1,2,3,4]
        IntStream range2 = IntStream.rangeClosed(1, 5); // [1,2,3,4,5]

        range1.forEach(i -> System.out.print(i + " "));
        System.out.println();
        range2.forEach(i -> System.out.print(i + " "));


        System.out.println("\n================================================================================");
        // 1. 통계 관련 메서드(sum, average, max, min, count)
        int sum = IntStream.range(1, 6).sum(); // 1 + 2 + 3 + 4 + 5 = 15
        System.out.println("sum = " + sum);

        // average(): 평균값 계산
        //OptionalDouble average = IntStream.range(1, 6).average();

        double average = IntStream.range(1, 6)
                .average()
                .getAsDouble(); //15

        // summaryStatics(): 모든 통계 정보
        IntSummaryStatistics statistics = IntStream.range(1, 6).summaryStatistics();
        System.out.println("합계: " + statistics.getSum());
        System.out.println("평균: " + statistics.getAverage());
        System.out.println("개수: " + statistics.getCount());
        System.out.println("최댓값: " + statistics.getMax());
        System.out.println("최솟값: " + statistics.getMin());


        System.out.println("\n================================================================================");
        // 2. 타입 변환 메서드
        //IntStream -> LongStream
        LongStream longStream = IntStream.range(1, 5).asLongStream();

        //IntStream -> DoubleStream
        DoubleStream doubleStream = IntStream.range(1, 5).asDoubleStream();

        // IntStream -> Stream<Integer>
        Stream<Integer> boxedStream = IntStream.range(1, 5).boxed();


        System.out.println("\n================================================================================");
        //3. 기본형 특화 매핑
        // int -> long 변환 매핑
        LongStream mappedLong = IntStream.range(1, 5)
                .mapToLong(i -> i * 10L);//long applyAsLong(int value);

        // int -> double
        DoubleStream mappedDouble = IntStream.range(1, 5)
                .mapToDouble(i -> i * 1.5); //double applyAsDouble(int value);

        // int -> 객체 변환 매핑
        Stream<String> mappedObj = IntStream.range(1, 5)
                .mapToObj(i -> "Number: " + i);

        System.out.println("\n================================================================================");
        // 4. 객체 스트림 -> 기본형 특화 스트림으로 매핑
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        IntStream intStream = integerStream.mapToInt(i -> i);


        System.out.println("\n================================================================================");
        // 5. 객체 스트림 -> 기본형 특화 스트림으로 매핑 활용
        int result = Stream.of(1, 2, 3, 4, 5)
                .mapToInt(i -> i)
                .sum();
        System.out.println("result = " + result);
    }
}
/*
- 기본형 특화 스트림 사용 시
  숫자 계산(합계, 평균 최대, 최소 등)을 간편하게 처리,
  박싱 / 언박싱 오버헤드를 줄여 성능상의 이점도 얻을 수 있음

- range(), rangeClosed() 등은 범위를 쉽게 다룰 수 있어 반복문 대신에 자주 쓰임

- mapToXxx(), boxed() 등의 메서드 활용 시 객체 스트림과 기본형 특화 스트림을 자유롭게 오가며 다양한 작업 가능

- summaryStatistics() 이용 시 합계, 평균, 최솟값, 최댓값 등 통계 정보를 한 번에 구할 수 있어 편리

슷자 중심 연산에서는 적극 활용하는 것을 고려
*/

/* 
for문 vs 스트림 vs 기본형 특화 스트림 성능차이 
부분은 pdf 참고
*/