package ch04applylambda.sub1filter.step1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// 람다 사용 o
public class FilterMainV2_After {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // 짝수만 거르기
        List<Integer> evenNumbers = filterNumber(numbers, num -> num % 2 == 0);
        System.out.println("evenNumbers = " + evenNumbers);
        
        // 홀수만 거르기
        List<Integer> oddNumbers = filterNumber(numbers, num -> num % 2 != 0);
        System.out.println("oddNumbers = " + oddNumbers);
    }

    private static List<Integer> filterNumber(List<Integer> numbers, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : numbers) {
            if (predicate.test(num)) {
                result.add(num);
            }
        }
        return result;
    }
}