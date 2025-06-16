package ch22enum.after.step3refactoring.ref2enum.step3;


import static ch22enum.after.step3refactoring.ref2enum.step3.Grade.*;


public class GradeEnumMain {
    public static void main(String[] args) {
        int price = 20000;

        printDiscount(BASIC, price);
        printDiscount(GOLD, price);
        printDiscount(DIAMOND, price);
    }

    private static void printDiscount(Grade grade, int price) {
        System.out.println(grade.name() + "등급 할인금액: " + grade.discount(price) + "원");
    }
}
