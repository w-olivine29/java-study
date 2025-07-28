package ch02lambda.step3simplification;

import ch01whylambda.MyFunction;

public class LambdaSimple1 {
    public static void main(String[] args) {

        //기본
        MyFunction function1 = (int a, int b) -> {
            return a + b;
        };
        System.out.println("function1.apply(1,2) = " + function1.apply(1, 2));


        /* 표현식이란?
            하나의 값으로 평가되는 코드 조각
            산술 논리 표현식, 메서드호출, 객체 생성 등
                ex) x+y, price * quantity, calculateToTal(), age >=18
            표현식이 아닌 것은 제어문, 메서드 선언 등이 있음
        */

        // 단일 표현식인 경우 - 중괄호, 리턴문 생략 가능
        MyFunction function2 = (int a, int b) -> a + b;
        System.out.println("function2.apply(1, 2) = " + function2.apply(1, 2));

        // 단일 표현식이 아닐 경우 - 중괄호와 리턴 모두 필수
        MyFunction function3 = (int a, int b) -> {
            System.out.println("Lambda run");
            return a + b;
        };
        System.out.println("function3.apply(1, 2) = " + function3.apply(1, 2));
    }
}
