package ch22enum.after.step3refactoring.ref1class;

public class ClassGradeMain {
    public static void main(String[] args) {
        DiscountService discountService = new DiscountService();
        int price = 20000;

        int basicDiscount = discountService.discount(ClassGrade.BASIC, price);
        int goldDiscount = discountService.discount(ClassGrade.GOLD, price);
        int diamondDiscount = discountService.discount(ClassGrade.DIAMOND, price);


        System.out.println("BASIC 등급 할인금액: " + basicDiscount + "원");
        System.out.println("GOLD 등급 할인금액: " + goldDiscount + "원");
        System.out.println("DIAMOND 등급 할인금액: " + diamondDiscount + "원");
        

    }
}
