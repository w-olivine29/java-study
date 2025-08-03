package ch04applylambda.sub1filter.step3generic;

import java.util.List;

import static ch04applylambda.sub1filter.step3generic.GenericFilter.*;

public class FilterMainV4_GenericUtil {
    public static void main(String[] args) {
        
        // 숫자 사용 필터
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // 짝수만 거르기
        List<Integer> evenNumbers = filter(numbers, num -> num % 2 == 0);
        System.out.println("evenNumbers = " + evenNumbers);

        
        // 문자 사용 필터
        List<String> strs = List.of("a", "bb", "ccc");
        List<String> strResult = filter(strs, str -> str.length() >= 2);
        System.out.println("strResult = " + strResult);
    }
}