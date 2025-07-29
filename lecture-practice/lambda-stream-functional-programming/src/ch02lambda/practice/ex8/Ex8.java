package ch02lambda.practice.ex8;

/* 함수를 반환하는 buildGreeter 만들기

문자열을 입력받아, 새로운 함수를 반환해주는 메서드 작성하기

ex) buildGreeter("Hello") -> "Hello" 를 사용하는 새로운 함수 반환
새로운 함수는 입력받은 문자열에 대해 greeting + "," + (입력받은 문자열) 형태로 결과 반환
함수를 반환받은 뒤에, 실제로 그 함수를 호출하여 결과 확인하기

실행결과 예시)
Hello, Java
Hi, Lambda
*/
public class Ex8 {
    public static void main(String[] args) {

        StringFunction function = buildGreeter("welcome");

        System.out.println(function.apply("lambda"));
    }

    private static StringFunction buildGreeter(String greeting) {

        return str -> greeting + "," + str;
    }

    @FunctionalInterface
    interface StringFunction {
        String apply(String str);
    }
}
