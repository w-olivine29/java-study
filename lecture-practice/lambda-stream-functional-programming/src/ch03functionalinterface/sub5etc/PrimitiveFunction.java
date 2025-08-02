package ch03functionalinterface.sub5etc;

import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntFunction;



public class PrimitiveFunction {
    public static void main(String[] args) {
        //기본형 매개변수 - IntFunction, LongFunction, DoubleFunction..(매개변수는 해당 타입으로 고정, 제네릭으로 반환타입만 받는다.)

        IntFunction<String> function = num -> "숫자: " + num;
        System.out.println("function.apply(10) = " + function.apply(10));
        
        // 기본형 반환 - ToIntFunction, ToLongFunction... (반환타입은 해당 타입으로 고정, 제네릭으로 파라미터 타입만 받는다.)
        ToIntFunction<String> toIntFunction = s -> s.length();
        System.out.println("toIntFunction.applyAsInt(\"function\") = " + toIntFunction.applyAsInt("function"));
        
        //기본형 매개변수, 기본형 반환
        IntToLongFunction intToLongFunction = x -> 100L;
        System.out.println("intToLongFunction.applyAsLong(1) = " + intToLongFunction.applyAsLong(1));

        // IntUnaryOperator: int -> int
        IntUnaryOperator intUnaryOperator = (x) -> x * 100;
        System.out.println("intUnaryOperator.applyAsInt(10) = " + intUnaryOperator.applyAsInt(10));

        // IntConsumer, IntSupplier, IntPredicate...
    }
}
