package ch05javachange;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class JavaStringTest {

    @Test
    void java8() {
        // String.join
        String str1 = String.join(",", "a", "b", "c");
        System.out.println(str1);

        // String.join with Collection
        String str2 = String.join(",", List.of("a", "b", "c"));
        System.out.println(str2);
    }

    @Test
    void java11() {
        // String.isBlank  문자열 길이 (공백문자 허용x)
        System.out.println(" ".isBlank()); //indexOfNonWhitespace() == length()
        System.out.println("abc".isBlank());

        // String.strip, string.stripLeading, string.stripTrailing
        System.out.println("   abc   ".strip()); // 양쪽 공백 지우기
        System.out.println("   abc   ".stripLeading()); // 앞 공백 지우기
        System.out.println("   abc   ".stripTrailing()); // 뒤 공백 지우기

        // String.lines
        String str = "abc\ndef\nghi";
        str.lines() //Stream<String>
                .forEach(System.out::println);

        // String.repeat
        System.out.println("abc".repeat(3));
    }

    @Test
    void java12() {
        // String.transform

        // 문자열을 함수에 전달해 변환 결과 반환
        // 체이닝 활용 ↑, 람다/메서드 참조로 가독성 ↑
        String str = "hello";
        String result = str.transform(s -> s.toUpperCase());
        System.out.println(result); //HELLO

        // String.transform chaining
        String result2 = str
                .transform(s -> s.toUpperCase()) //string ->
                .transform(s -> s + " world");
        System.out.println(result2); //HELLO world
    }

    @Test
    void java13() {
        // String TextBlock (정식기능으로써 도입은 Java 15~)

        // 여러 줄의 문자열을 간단히 표현
        // 가독성 ↑, 이스케이프 사용 ↓, JSON/SQL 등 멀티라인 처리 용이
        String textBlock = """
                Hello, \n
                World! \s
                World!
                """;
        System.out.println(textBlock);
    }



    @Test
    void java15() {
        // String formatting .formatted

        // 기존 String.format() 대신 인스턴스 메서드로  사용 가능
        String formattedString = "My name is %s and I am %d years old.".formatted("John", 30);
        System.out.println(formattedString);

        Map<String, Integer> map = Map.of(
                "apple", 1,
                "banana", 2,
                "cherry", 3
        );

        // 컬렉션 처리 시에도 손쉽게 문자열 템플릿 적용 가능
        map.forEach((k, v) -> System.out.println("i'm %s: %d age".formatted(k, v)));
    }

}