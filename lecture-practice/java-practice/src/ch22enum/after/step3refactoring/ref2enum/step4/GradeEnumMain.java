package ch22enum.after.step3refactoring.ref2enum.step4;


import static ch22enum.after.step3refactoring.ref2enum.step4.Grade.*;


public class GradeEnumMain {
    public static void main(String[] args) {
        int price = 20000;

        for (Grade value : values()) {
            printDiscount(value, price);
        }
    }

    private static void printDiscount(Grade grade, int price) {
        System.out.println(grade.name() + "등급 할인금액: " + grade.discount(price) + "원");
    }
}
