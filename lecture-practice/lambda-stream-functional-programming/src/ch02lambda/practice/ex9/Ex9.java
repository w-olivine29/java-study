package ch02lambda.practice.ex9;

/* 함수 합성하기 (compose)
람다를 전달하고 또 람다를 반환까지 하는 복잡한 문제 풀어보기

문자열을 변환하는 함수 두 개 (MyTransformer 타입) 을 받아서,
f1을 먼저 적용 후 그 결과에 f2를 적용하는 새로운 함수를 반환하는 compose 메서드 만들기.
ex) f2(f1(x))

f1: 대문자로 바꿈
f2: 문자 앞 뒤에 "**"를 붙임
합성 함수(compose())를 "hello" 에 적용하면 -> "**HELLO**"

*/
public class Ex9 {
    public static void main(String[] args) {
        String target = "abc";

        MyTransformer transformer1 = (str) -> str.toUpperCase();
        MyTransformer transformer2 = (str) -> "**" + str + "**";

        MyTransformer composer = compose(transformer1, transformer2);
        String result = composer.transform(target);
        System.out.println("result = " + result);

    }

    private static MyTransformer compose(MyTransformer transformer1, MyTransformer transformer2) {
        return (str) -> {
            String transform = transformer1.transform(str);
            return transformer2.transform(transform);
        };
    }

    @FunctionalInterface
    interface MyTransformer {
        String transform(String str);
    }
}
