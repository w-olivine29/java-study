package ch03functionalinterface.sub3basic;

import java.util.function.Consumer;

// 입력값을 받고 반환x
// 대표 사용 예시: 로그 출력, DB 저장 등
public class ConsumerMain {
    public static void main(String[] args) {

        // 익명클래스
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("s = " + s);
            }
        };
        consumer1.accept("consumer");

        //람다
        Consumer<String> consumer2 = str -> System.out.println(str);
        consumer2.accept("consumer");
    }

}
