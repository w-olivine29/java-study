package ch03functionalinterface.sub5etc;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiMain {
    public static void main(String[] args) {

        // BiFunction<T,T,T>
        BiFunction<Integer,Integer,Integer> add = (a,b) -> a + b;
        System.out.println("add.apply(1,2) = " + add.apply(1, 2));

        // BiConsumer<T,U>
        BiConsumer<String, Integer> repeat = (str, num) ->{
            for (int i = 0; i < num; i++) {
                System.out.print(str);
            }
            System.out.println();
        };
        repeat.accept("*",5);

        //BiPredicate<T, U>
        BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
        System.out.println("isGreater.test(1,3) = " + isGreater.test(1, 3));

        // Supplier는 입력값 존재하지 않기 때문에 BiSupplier는 없음
    }
}
