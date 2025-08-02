package ch03functionalinterface.practice.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/*
ch2 에서 풀이했던 문제를 자바가 제공하는 함수형 인터페이스로 대체
*/
public class Ex6After {
    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "C", "d", "E", "f", "G");

        System.out.println(mappingStr(list, (str) -> str.toUpperCase()));
        System.out.println(mappingStr(list, (str) -> "***" + str
        ));
    }

    // Function<String, String> 도 가능
    private static List<String> mappingStr(List<String> list, UnaryOperator<String> function) {
        List<String> result = new ArrayList<>();
        for (String string : list) {
            result.add(function.apply(string));
        }
        return result;
    }
}
