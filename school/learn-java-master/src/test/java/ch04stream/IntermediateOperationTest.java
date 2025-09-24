package ch04stream;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperationTest {
    private final Faker faker = new Faker();

    // 1~10 사이 숫자에서 짝수만 필터링
    @Test
    void filter() {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers1 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println(evenNumbers1);


        List<Integer> evenNumbers2 = IntStream.rangeClosed(1, 10)
                .filter(n -> n % 2 == 0)
                .boxed()
                .toList();
        System.out.println("evenNumbers2 = " + evenNumbers2);
    }

    //10명의 이름 리스트 -> 이름 길이 리스트 변환
    @Test
    void map() {

        // 컬렉션 등에서 스트림으로 만들지 않고, 처음부터 스트림으로 시작하는 법
        List<String> names = Stream.generate(() -> faker.name().fullName())
                .limit(10)
                .toList();
        System.out.println(names);

        List<Integer> nameLengthList = names.stream().map(name -> name.length()) //String::length
                .toList();
        System.out.println("nameLengthList = " + nameLengthList);
    }


    // 10명의 이름 리스트 -> 이름을 한글자씩 나눈 List 만들기
    // ex) Java -> ['J','a','v','a']
    // map 과 flatMap 의 차이 확인하기
    @Test
    void mapVsFlatMap() {

        List<String> names = Stream.generate(() -> faker.name().firstName()) //Stream<String>
                .limit(10).toList();
        System.out.println(names); //[Chad, Blair, Sharell, Walker, Merri, Barb, Malka, Billy, Marylou, Sirena]

        //map
        List<List<String>> result1 = names.stream()
                .map(name -> List.of(name.split(""))) //Stream<List<...>>
                .toList();
        System.out.println(result1); // [[C, h, a, d], [B, l, a, i, r], [S, h, a, r, e, l, l] ...


        // flatmap (중첩구조인 요소를 평탄화)
        List<String> result2 = names.stream()
                .flatMap(name -> Stream.of(name.split(""))) //Stream<String>
                .toList();
        System.out.println(result2); // [C, h, a, d, B, l, a, i, r, S, h, a, r, e, l, l....
    }


    // 1~100 의 숫자 -> 5로 나눈 나머지 list (중복허용 x)
    @Test
    void distinct() {

        List<Integer> noDistinct = IntStream.rangeClosed(1, 100)
                .map(num -> num % 5)
                .boxed()
                //.distinct()
                .toList();
        System.out.println(noDistinct); //[1, 2, 3, 4, 0, 1, 2, 3, 4, 0, 1, 2, .....

        List<Integer> distinct = noDistinct.stream()
                .distinct()
                .toList();
        System.out.println(distinct); //[1, 2, 3, 4, 0]
    }


    // 1~100 사이 랜덤 숫자 -> 정렬
    @Test
    void sorted() {
        List<Integer> numbers = Stream.generate(() -> faker.number().numberBetween(1, 100))
                .limit(10)
                .toList();
        System.out.println(numbers);

        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .toList();
        System.out.println(sortedNumbers);
    }


    // 1~100 사이 랜덤 숫자 -> 출력 (4개 스킵 후 출력)
    @Test
    void skip() {
        List<Integer> numbers = Stream.generate(() -> faker.number().numberBetween(1, 100))
                .limit(10)
                .toList();
        System.out.println(numbers); //[22, 98, 81, 63, 59, 70, 14, 39, 36, 21]

        List<Integer> skipNumbers = numbers.stream()
                .skip(4)
                .toList();
        System.out.println(skipNumbers); //[59, 70, 14, 39, 36, 21]
    }
}
