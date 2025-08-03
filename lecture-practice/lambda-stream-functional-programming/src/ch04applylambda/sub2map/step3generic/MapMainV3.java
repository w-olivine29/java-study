package ch04applylambda.sub2map.step3generic;

import java.util.List;

import static ch04applylambda.sub2map.step3generic.GenericMapper.*;

public class MapMainV3 {
    public static void main(String[] args) {

        // 문자열 -> 숫자 변환
        List<Integer> numbers = map(List.of("1", "10", "100", "1000", "10000"), str -> Integer.valueOf(str));
        System.out.println("numbers = " + numbers);

        // 숫자 -> 문자열 변환
        List<String> strings = map(List.of(1, 2, 3, 4, 5), num -> "*".repeat(num));
        System.out.println("strings = " + strings);
        
        // 문자열 -> 문자열 변환
        List<String> upperCases = map(List.of("a", "b", "c"), str -> str.toUpperCase());
        System.out.println("upperCases = " + upperCases);
    }

}
