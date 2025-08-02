package ch03functionalinterface.practice.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/*
ch2 에서 풀이했던 문제를 자바가 제공하는 함수형 인터페이스로 대체
*/
public class Ex5After {
    public static void main(String[] args) {

        List<Integer> list = List.of(14, 7, 2, 3, 6, 7, 10, -55, -4, -22);

        // 음수
        List<Integer> negativeNumbers = filter(list, (value) -> value < 0);
        System.out.println("negativeNumbers = " + negativeNumbers);


        // 짝수
        List<Integer> evenNumbers = filter(list, (value) -> value % 2 == 0);
        System.out.println("evenNumbers = " + evenNumbers);

    }

    // filter 는 함수를 파라미터로 받는 고차함수다
    static <T> List<T> filter(List<T> list, Predicate<T> predicate) {

        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
