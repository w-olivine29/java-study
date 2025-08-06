package ch07stream.sub2basic.step2noneduplicated;

import java.util.List;
import java.util.stream.Stream;

public class DuplicateExecutionMain {
    public static void main(String[] args) {

        // 스트림 중복 실행 확인
        Stream<Integer> stream = Stream.of(1, 2, 3);
        stream.forEach(System.out::println); // 1. 최초 실행

        // 2. 스트림 중복 실행 시도
        //Stream has already been linked or consumed
        //stream.forEach(System.out::println); // IllegalStateException: stream has already been operated upon or closed


        // 스트림을 여러번 쓰고싶을 때
        // 대안: 대상 리스트를 스트림으로 새로 생성해서 사용 (재사용은 불가)
        List<Integer> list = List.of(1, 2, 3);
        Stream.of(list).forEach(System.out::println); //[1, 2, 3]
        Stream.of(list).forEach(System.out::println); //[1, 2, 3]

    }
}
