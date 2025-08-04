package ch06methodreference.sub1intro.before;

import java.util.function.BinaryOperator;

public class MethodRefStartV2 {
    public static void main(String[] args) {

        BinaryOperator<Integer> add1 = (x, y) -> add(x,y);
        BinaryOperator<Integer> add2 = (x, y) -> add(x,y);

        Integer result1 = add1.apply(1, 2);
        System.out.println("result1 = " + result1);

        Integer result2 = add2.apply(1, 2);
        System.out.println("result2 = " + result2);
    }

    static int add(int x, int y){
        return x + y;
    }
}
/*
로직을 별도의 메서드로 분리하고, 
람다는 해당 메서드를 호출하는 방식으로 중복을 해결

But
단순한 로직인데도,
람다를 작성할 때마다  (x, y) -> add(x,y) 형태의 코드를 반복 작성해야함
로직에 비해 매개변수를 전달하는 부분이 장황하다.

next step)
    메서드 참조 적용
*/