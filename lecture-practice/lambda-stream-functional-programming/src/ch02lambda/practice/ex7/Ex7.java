package ch02lambda.practice.ex7;

import java.util.List;

/* reduce(또는 fold) 함수 구현

정수 리스트를 받아서, 모든 값을 하나로 누적하는 함수 만들기
reduce(List<Integer>list, int initial, MyReducer reducer)
    - initial 은 누적 계산의 초깃값
    - MyReducer
        int reduce(int a, int b)

- 연산 1: 리스트 [1,2,3,4] 를 모두 더하기
- 연산 2: 리스트 [1,2,3,4] 를 모두 곱하기

*/
public class Ex7 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4);

        System.out.println(reduce(list, 0, (a, b) -> a + b));
        System.out.println(reduce(list, 1, (a, b) -> a * b));
    }

    private static int reduce(List<Integer> list, int initial, Reducer reducer) {
        int result = initial;
        for (Integer num : list) {
            result = reducer.reduce(result, num);
        }
        return result;
    }

    @FunctionalInterface
    interface Reducer {
        int reduce(int a, int b);
    }
}
