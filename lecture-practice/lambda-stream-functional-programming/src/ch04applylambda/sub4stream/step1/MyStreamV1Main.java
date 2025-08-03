package ch04applylambda.sub4stream.step1;

import java.util.List;

public class MyStreamV1Main {
    public static void main(String[] args) {
        // 짝수만 남기고 남은 값의 2배 반환

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result = returnValue(numbers);
        System.out.println("result = " + result);
    }

    private static List<Integer> returnValue(List<Integer> numbers) {
        MyStreamV1 myStream = new MyStreamV1(numbers);

        // 메서드 체인 형식
        return myStream
                .filter(num -> num % 2 == 0)
                .map(num -> num * 2)
                .toList();
    }
}
