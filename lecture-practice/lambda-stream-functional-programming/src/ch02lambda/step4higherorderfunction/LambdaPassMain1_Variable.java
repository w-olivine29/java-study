package ch02lambda.step4higherorderfunction;

import ch01whylambda.MyFunction;

// 1. 람다를 변수에 대입
public class LambdaPassMain1_Variable {
    public static void main(String[] args) {
        
        // 1. 람다 인스턴스 (MyFunction 구현체) 생성
        // MyFunction 타입으로 선언한 변수에 람다 인스턴스의 참조값을 대입
        MyFunction add = (a, b) -> a + b;
        MyFunction sub = (a, b) -> a - b;

        System.out.println("add.apply(a,b) = " + add.apply(1, 2)); //3
        System.out.println("sub.apply(a,b) = " + sub.apply(1, 2)); //-1

        // add의 참조값 대입
        MyFunction cal = add;
        System.out.println("cal.apply(1, 2) = " + cal.apply(1, 2)); //3

        // sub의 참조값 대입
        cal = sub;
        System.out.println("cal.apply(1,2) = " + cal.apply(1, 2)); //-1
    }
}
