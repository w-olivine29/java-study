package ch04stream;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class TerminalOperationTest {
    private final Faker faker = new Faker();

    @Test
    void forEach() {
        Stream.generate(() -> faker.name().firstName())
                .limit(10)
                .forEach(System.out::println);
    }

    @Test
    void count() {
        long count = Stream.generate(() -> faker.name().firstName())
                .limit(10)
                .count();
        System.out.println("count = " + count);
    }


    @Test
    void match() {
        
/* 파이프라이닝: 여러 개의 중간 연산을 하나의 “연속된 파이프라인”처럼 연결하여, 각 요소가 최종 연산에 도달할 때까지 단계별로 처리되는 방식

        - 스트림은 "지연 연산(Lazy Evaluation)"을 사용
          → 최종 연산(anyMatch, allMatch, noneMatch 등)이 실행될 때 비로소 요소가 생성·소비 시작

             일반 for문으로 구현했다면,
                [10개 생성 → 10개 출력 → 10개 검사] 단계별 일괄 처리

             스트림으로 사용 시
                [요소 1개 생성 → peek → match 검사]를 요소마다 순차적으로 묶어서 수행  (반복)
                (요소 단위로 파이프를 통과하는 구조라고 보면 된다)

                match 조건이 확정되면 즉시 스트림 처리를 종료

                ->
*/

        boolean anyMatch = Stream.generate(() -> faker.number().numberBetween(1, 5))
                .limit(10)
                .peek(System.out::println)
                .anyMatch(i -> i == 3);
        System.out.println("anyMatch: " + anyMatch);

        boolean allMatch = Stream.generate(() -> faker.number().numberBetween(1, 5))
                .limit(10)
                .peek(System.out::println)
                .allMatch(i -> i == 3);
        System.out.println("allMatch: " + allMatch);

        boolean noneMatch = Stream.generate(() -> faker.number().numberBetween(1, 5))
                .limit(10)
                .peek(System.out::println)
                .noneMatch(i -> i == 3);
        System.out.println("noneMatch: " + noneMatch);
    }


    @Test
    void findFirst() {
        int num = Stream.generate(() -> faker.number().numberBetween(1, 10))
                .limit(10)
                .peek(System.out::println)
                .findFirst() //Optional<Integer>
                .orElse(0);

        System.out.println(num);
    }


    // 문자열 10개 생성 -> 하나의 문자열
    @Test
    void reduce() {

        // 해당 코드는 단순 reduce 실습 (실제로는 직접 문자열 더하기 연산 반복은 지양)
        // 가변 문자열 클래스를 직접 활용하거나, 
        // .collect(Collectors.joining("//")) 사용 (내부적으로 StringBuilder 사용)
        String pokemonsName = Stream.generate(() -> faker.pokemon().name())
                .limit(10)
                .peek(System.out::println)
                .reduce((p1, p2) -> p1 + "//" + p2)
                .orElse("No Name");
        System.out.println(pokemonsName);
        
        
        //reduce() 활용방식이 많으니 따로 보는 걸 추천
    }
}
