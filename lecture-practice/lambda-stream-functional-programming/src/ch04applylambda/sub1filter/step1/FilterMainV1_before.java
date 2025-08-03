package ch04applylambda.sub1filter.step1;

import java.util.ArrayList;
import java.util.List;

// 람다 사용 x
public class FilterMainV1_before {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 짝수만 거르기
        List<Integer> evenNumbers = filterEvenNumber(numbers);
        System.out.println("evenNumbers = " + evenNumbers);

        // 홀수만 거르기
        List<Integer> oddNumbers = filterOddNumber(numbers);
        System.out.println("oddNumbers = " + oddNumbers);
    }

    private static List<Integer> filterEvenNumber(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : numbers) {
            if (num % 2 == 0) {
                result.add(num);
            }
        }

        return result;
    }

    private static List<Integer> filterOddNumber(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : numbers) {
            if (num % 2 != 0) {
                result.add(num);
            }
        }
        return result;
    }
}