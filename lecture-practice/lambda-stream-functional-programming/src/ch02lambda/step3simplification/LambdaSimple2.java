package ch02lambda.step3simplification;

import ch01whylambda.Procedure;

public class LambdaSimple2 {
    public static void main(String[] args) {

        Procedure procedure1 = () -> {
            System.out.println("welcome Lambda");
        };
        procedure1.run();

        // 단일 표현식 - 중괄호 생략 가능
        Procedure procedure2 = () -> System.out.println("welcome Lambda");
    }
}
