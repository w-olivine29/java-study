package ch22enum.after.step3refactoring.ref2enum.step1;

import static ch22enum.after.step3refactoring.ref2enum.step1.Grade.*;

public class GradeEnumMain {
    public static void main(String[] args) {
        DiscountService discountService = new DiscountService();
        int price = 20000;

        int basicDiscount = discountService.discount(BASIC, price);
        int goldDiscount = discountService.discount(GOLD, price);
        int diamondDiscount = discountService.discount(DIAMOND, price);

        System.out.println("BASIC 등급 할인금액: " + basicDiscount + "원");
        System.out.println("GOLD 등급 할인금액: " + goldDiscount + "원");
        System.out.println("DIAMOND 등급 할인금액: " + diamondDiscount + "원");


    }
}
