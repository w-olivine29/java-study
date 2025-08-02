package ch03functionalinterface.sub3basic;

import java.util.Random;
import java.util.function.Supplier;

// Supplier 공급자
// 입력값 x, 반환값 o
// 대표 사용 예시: 객체 생성 값, 값 반환 등
public class SupplierMain {
    public static void main(String[] args) {

        // 익명클래스
        Supplier<Integer> supplier1 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(10);
            }
        };
        System.out.println("supplier1.get() = " + supplier1.get());

        // 람다
        Supplier<Integer> supplier2 = ()-> new Random().nextInt(10);
        System.out.println("supplier2.get() = " + supplier2.get());
    }

}
