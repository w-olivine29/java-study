package ch02lambda.practice.ex5;

import java.util.ArrayList;
import java.util.List;

/* filter 함수 구현
정수 리스트가 주어졌을 때, 특정 조건에 맞는 요소들만 뽑아내는 filter 함수 만들어보기
리스트, 특정조건 을 매개변수로 받는 정적 메서드 작성

특정조건은 MyPredicate 라는 함수형 인터페이스 - boolean test(int value) 메서드

조건 예시)
    - 음수만 골라내기
    - 짝수만 골라내기
*/
public class Ex5 {
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
    static List<Integer> filter(List<Integer> list, MyPredicate predicate) {

        List<Integer> result = new ArrayList<>();
        for (Integer integer : list) {
            if (predicate.test(integer)) {
                result.add(integer);
            }
        }
        return result;
    }


    @FunctionalInterface
    interface MyPredicate {
        boolean test(int value);
    }
}
