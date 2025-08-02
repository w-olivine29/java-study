package ch03functionalinterface.sub2target;

import java.util.function.Function;


/* 자바가 기본으로 제공하는 Function 대입
public interface Function<T, R> {
 R apply(T t);
}
*/
public class TargetType3_Function {
    public static void main(String[] args) {
        // 람다 직접 대입: 문제 없음
        Function<Integer, String> functionA = i -> "value =" + i;
        System.out.println("functionA.apply(5) = " + functionA.apply(5));

        // 이미 선언한 람다를 같은 타입에 대입: 문제 없음
        Function<Integer, String> functionB = functionA;
        System.out.println("functionB.apply(5) = " + functionB.apply(5));
    }
}
