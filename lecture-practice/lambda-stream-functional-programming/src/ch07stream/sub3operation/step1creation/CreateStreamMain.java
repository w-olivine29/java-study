package ch07stream.sub3operation.step1creation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamMain {
    public static void main(String[] args) {
        System.out.println("\n1. 컬렉션으로부터 생성 ======================================");
        List<String> list = List.of("m", "i", "n", "t");
        Stream<String> stream1 = list.stream();
        stream1.forEach(System.out::println);

        System.out.println("\n2. 배열로부터 생성 ======================================");
        String[] arr = {"m", "i", "n", "t"};
        Stream<String> stream2 = Arrays.stream(arr);
        stream2.forEach(System.out::println);

        System.out.println("\n3. Stream.of() 사용 ======================================");
        Stream<String> stream3 = Stream.of("m", "i", "n", "t"); // 배열, 컬렉션으로 넣는 것도 가능
        stream3.forEach(System.out::println);

        
        // iterate, generate 는 별도의 종료 조건이 없으면 무한히 데이터를 만들어내는 스트림
        System.out.println("\n4. 무한 스트림 생성 - iterate() ======================================");
        //iterate: 초기값과 다음 값을 만드는 함수를 지정

        // 첫번째 값을 기반으로 다음 값을 만드는 함수를 지정
        // Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2);

        // limit 중간연산: 스트림의 값 중 n개만 사용
        infiniteStream.limit(3).forEach(System.out::println);

        System.out.println("\n5. 무한 스트림 생성 - generate() ======================================");
        // generate: Supplier를 사용하여 무한하게 생성

        Stream<Double> randomStream = Stream.generate(Math::random);
        randomStream.limit(2).forEach(System.out::println);
    }
}
