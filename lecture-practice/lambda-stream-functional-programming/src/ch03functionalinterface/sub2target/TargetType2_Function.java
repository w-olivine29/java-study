package ch03functionalinterface.sub2target;

import java.util.function.Function;


/* 자바가 기본으로 제공하는 Function 사용
public interface Function<T, R> {
 R apply(T t);
}
*/
public class TargetType2_Function {
    public static void main(String[] args) {
        Function<String, String> upperCase = str -> str.toUpperCase();
        String result1 = upperCase.apply("welcome");
        System.out.println("result1 = " + result1);

        Function<Integer, Integer> square = n -> n * n;
        Integer result2 = square.apply(5);
        System.out.println("result2 = " + result2);


    }
}
