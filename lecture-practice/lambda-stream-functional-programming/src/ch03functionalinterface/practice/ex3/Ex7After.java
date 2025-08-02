package ch03functionalinterface.practice.ex3;

import java.util.List;
import java.util.function.BinaryOperator;

/*
ch2 에서 풀이했던 문제를 자바가 제공하는 함수형 인터페이스로 대체
*/
public class Ex7After {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4);

        System.out.println(reduce(list, 0, (a, b) -> a + b));
        System.out.println(reduce(list, 1, (a, b) -> a * b));
    }

    private static int reduce(List<Integer> list, int initial, BinaryOperator<Integer> reducer) {
        int result = initial;
        for (Integer num : list) {
            result = reducer.apply(result, num);
        }
        return result;
    }

    // 동일 타입 파라미터 2개, 동일 타입의 반환값 -> BinaryOperator
//    @FunctionalInterface
//    interface Reducer {
//        int reduce(int a, int b);
//    }
}
