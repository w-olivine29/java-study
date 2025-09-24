package ch03.functionalinterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // 함수형 인터페이스의 이름 뜻을 보면 어떤 형태인지 자연스럽게 연상할 수 있음
        
        // Consumer - 입력값 o, 반환값 x
        Consumer<String> printConsumer = s -> System.out.println("Consumer: " + s);
        printConsumer.accept("안녕하세요");

        // Supplier - 입력값 x, 반환값 o
        Supplier<String> stringSupplier = () -> "공급된 문자열";
        System.out.println("Supplier: " + stringSupplier.get());

        // Predicate - 입력값 o, 반환값 o (boolean)
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("2는 짝수인가? " + isEven.test(2));

        // Function - 입력값 o, 반환값 o
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("문자열 길이: " + stringLength.apply("안녕하세요"));
    }
}
