package ch02lambda.step3simplification;

public class LambdaSimple4 {
    public static void main(String[] args) {
        MyCall call1 = (int value) -> value * 2; //기본
        
        MyCall call2 = (value) -> value * 2; // 타입추론
        
        MyCall call3 = value -> value * 2; // 매개변수가 1개일때 () 생략가능

    }

    interface MyCall {
        int call(int value);
    }
}

/*
- 매개변수 타입: 생략 간능하나, 필요시 명시적 작성 가능
- 반환타입: 문법적 명시 불가, 식의 결과를  보고 컴파일러가 항상 추론

람다는 간략하게 사용하는 것을 권장
 - 단일 표현식 -> 중괄호, 리턴문 생략
 - 타입 추론을 통해 매개변수 타입 생략 (컴파일러가 추론 가능하다면 생략)
*/