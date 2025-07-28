package ch02lambda.step3simplification;

import ch01whylambda.MyFunction;

public class LambdaSimple3_TypeInference {
    public static void main(String[] args) {
        // 타입 생략 전 (타입 직접 입력)
        MyFunction myFunction1 = (int a, int b) -> a + b;

        // MyFunction 타입을 통해 타입 추론 가능 (람다는 타입 생략 가능)
        // 컴파일러가 추론해준다
        MyFunction myFunction2 = (a, b) -> a + b;

        System.out.println("myFunction2.apply(1,2) = " + myFunction2.apply(1, 2));
    }
}
