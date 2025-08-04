package ch06methodreference.sub1intro.before;

import java.util.function.BinaryOperator;

public class MethodRefStartV1 {
    public static void main(String[] args) {

        BinaryOperator<Integer> add1 = (x, y) -> x + y;
        BinaryOperator<Integer> add2 = (x, y) -> x + y;

        Integer result1 = add1.apply(1, 2);
        System.out.println("result1 = " + result1);

        Integer result2 = add2.apply(1, 2);
        System.out.println("result2 = " + result2);
    }
}
/* 
- 동일한 기능을 하는 람다를 여러 번 작성하는 상황
- 코드 중복되어 유지보수 어려울 수 있음
    -> 로직 변경 시 중복됐던 모든 람다는 각각 수정해야함
    
next step) 
    코드 중복을 해결해보자
*/