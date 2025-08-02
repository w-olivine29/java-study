package ch03functionalinterface.sub4specialized;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/*
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T>

@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T,T,T>{
    R apply(T t, U u);
}
입력(피연산자) 와 결과(연산결과) 가 동일한 타입인 연산 수행 시 사용
- 단항 연산(입력 1개), 반환 타입 동일
    -> UnaryOperator<T>
- 이항 연산(입력 2개), 반환 타입 동일
    -> BinaryOperator<T>

*/

public class OperatorMain {
    public static void main(String[] args) {

        // UnaryOperator
        Function<Integer, Integer> square1 = x -> x * x;
        UnaryOperator<Integer> square2 = x -> x * x;

        System.out.println("square1.apply(5) = " + square1.apply(5));
        System.out.println("square2.apply(5) = " + square2.apply(5));

        //BinaryOperator
        BiFunction<Integer, Integer, Integer>  additional1 = (a,b) -> a + b;
        BinaryOperator<Integer> additional2 = (a,b) -> a + b;

        System.out.println("additional1.apply(1,2) = " + additional1.apply(1,2));
        System.out.println("additional2.apply(1,2) = " + additional2);
    }
}
