package ch02lambda.step4higherorderfunction;

import ch01whylambda.MyFunction;

// 람다를 반환
public class LambdaPassMain3_Return {
    public static void main(String[] args) {
        MyFunction add = getOperation("add");
        System.out.println("add.apply(1,2) = " + add.apply(1, 2)); //3

        MyFunction sub = getOperation("sub");
        System.out.println("sub.apply(1,2) = " + sub.apply(1, 2)); //-1

        MyFunction none = getOperation("what?");
        System.out.println("none.apply(1,2) = " + none.apply(1, 2)); //0
    }

    static MyFunction getOperation(String operator) {
        return switch (operator) {
            case "add" -> (a, b) -> a + b;
            case "sub" -> (a, b) -> a - b;
            default -> (a, b) -> 0;
        };
    }
}

/*
람다식 자체가 하나의 함수형인터페이스를 구현한 익명 구현체이지만,
코드 상으로는 
마치 람다식이라는 함수를 하나의 값처럼 취급하는 느낌m,.

함수를 변수에 저장
함수를 메서드에 전달
함수를 리턴
*/

/* 고차 함수
함수를 다루는 추상화 수준이 더 높다는 데에서 유래
- 보통의 일반적인 함수는 데이터(값)을 입력으로 받고, 값을 반환
- 고차함수 
    함수를 인자로 받거나 함수를 반환

일반 함수는 값을 다루지만,
고차 함수는 함수 자체를 다룬다.  (내가 함수인데, 다른 함수를 받거나 반환)

함수라는 개념 자체를 값처럼 다룬다는 점에서 추상화의 수준이 한단계 높아진다는 뜻으로 고차원 함수라고 한다.
*/