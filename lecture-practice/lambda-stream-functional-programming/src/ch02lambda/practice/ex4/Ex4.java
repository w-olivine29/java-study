package ch02lambda.practice.ex4;

/* 고차 함수 - 함수 반환

두 정수를 받아서 연산하는 MyFunction 인터페이스 사용

static MyFunction getOperation(String operator) 만들기
    - 매개변수인 operator에 따라 다음과 같은 내용 전달, 반환
        - operator 가 "add" 면 (a,b) 를 받아 a+b를 반환하는 람다 반환
        - sub는 빼기로
        - 그 외는 0 리턴

메인메서드에서 각각 호출해서 반환된 람다 실행하기
*/
public class Ex4 {
    public static void main(String[] args) {
        MyFunction add = getOperation("add");
        MyFunction sub = getOperation("sub");
        MyFunction xxx = getOperation("xxx");

        System.out.println("add.apply(5, 9) = " + add.apply(5, 9));
        System.out.println("sub.apply(5, 9) = " + sub.apply(5, 9));
        System.out.println("xxx.apply(5, 9) = " + xxx.apply(5, 9));
    }

    static MyFunction getOperation(String operator) {
        return switch (operator) {
            case "add" -> (a, b) -> a + b;
            case "sub" -> (a, b) -> a - b;
            default -> (a, b) -> 0;
        };
    }


    @FunctionalInterface
    interface MyFunction {
        int apply(int a, int b);
    }
}
