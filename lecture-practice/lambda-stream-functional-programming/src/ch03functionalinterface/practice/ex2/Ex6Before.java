package ch03functionalinterface.practice.ex2;

import java.util.ArrayList;
import java.util.List;

/* map 함수 구현하기

문자열 리스트를 입력받아, 각 문자열을 어떤 방식으로 변환(매핑)할지 결정하는 함수 만들기

map(리스트, 방식)
 - StringFunction 함수형 인터페이스
    - String apply(String s)

방식 예시)
 변환1: 모든 문자열을 대문자로 변경
 변환2: 문자옆 앞에 *** 를 붙여서 반환

*/
public class Ex6Before {
    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "C", "d", "E", "f", "G");

        System.out.println(mappingStr(list, (str) -> str.toUpperCase()));
        System.out.println(mappingStr(list, (str) -> "***" + str
        ));

    }

    private static List<String> mappingStr(List<String> list, StringFunction function) {
        List<String> result = new ArrayList<>();
        for (String string : list) {
            result.add(function.apply(string));
        }
        return result;
    }

    @FunctionalInterface
    interface StringFunction {
        String apply(String str);
    }
}
