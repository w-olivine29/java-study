package ch04applylambda.sub1filter.step2util;

import java.util.List;

import static ch04applylambda.sub1filter.step2util.IntegerFilter.*;

public class FilterMainV3_Util {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // 짝수만 거르기
        List<Integer> evenNumbers = filter(numbers, num -> num % 2 == 0);
        System.out.println("evenNumbers = " + evenNumbers);
        
        // 홀수만 거르기
        List<Integer> oddNumbers = filter(numbers, num -> num % 2 != 0);
        System.out.println("oddNumbers = " + oddNumbers);
    }
}