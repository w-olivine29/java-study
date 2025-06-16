package ch22enum.after.step1enum;

import static ch22enum.after.step1enum.Grade.*;

public class EnumMain {
    public static void main(String[] args) {

        // enum은 직접 인스턴스 생성 불가
        DiscountService discountService = new DiscountService();
        int price = 20000;

        int basicDiscount = discountService.discount(BASIC, price);
        int goldDiscount = discountService.discount(GOLD, price);
        //int diamondDiscount = discountService.discount(new Grade(), price); //Enum types cannot be instantiated

        System.out.println("BASIC 등급 할인금액: " + basicDiscount + "원");
        System.out.println("GOLD 등급 할인금액: " + goldDiscount + "원");


        // enum 클래스는 java.lang.Enum 를 강제상속 -> 추가로 다른 클래스 상속불가 (인터페이스는 구현가능)
        Class<? super Grade> superclass = Grade.class.getSuperclass();
        System.out.println("Grade.class.getSuperclass() -> " + superclass); // class java.lang.Enum
        
        // 열거형에 추상메서드 선언, 구현 가능 -> 익명클래스 부분 참조
    }
}
