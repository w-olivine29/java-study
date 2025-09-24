package ch04stream;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class EtcTest {
    private final Faker faker = new Faker();

    @Test
    void streamCanNotBeReused() {
        Stream<String> names = Stream.generate(() -> faker.name().fullName())
                .limit(2);

        names.forEach(System.out::println);

        // 스트림은 최종연산 후에는 재사용 불가
        //names.forEach(System.out::println); //java.lang.IllegalStateException: stream has already been operated upon or closed
    }

    @Test
    void streamNeedReused() {
        List<String> names = Stream.generate(() -> faker.name().fullName())
                .limit(2)
                .toList();

        // 문제 없음 (같은 컬렉션으로부터 만든 서로 다른 스트림)
        names.stream().forEach(System.out::println);
        names.stream().forEach(System.out::println);
    }
}
