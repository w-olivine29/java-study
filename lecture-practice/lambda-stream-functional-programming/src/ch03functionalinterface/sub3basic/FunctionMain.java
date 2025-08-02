package ch03functionalinterface.sub3basic;

import java.util.function.Function;

// 입력값 받고, 반환값 o
// 대표사용예시: 데이터 변환, 필드 추출 등
public class FunctionMain {
    public static void main(String[] args) {
        // 익명 클래스
        Function<String, Integer> function1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        System.out.println("function1.apply(\"welcome\") = " + function1.apply("welcome"));

        // 람다
        Function<String, Integer> function2 = s -> s.length();
        System.out.println("function2.apply(\"welcome\") = " + function2.apply("welcome"));
    }
}
