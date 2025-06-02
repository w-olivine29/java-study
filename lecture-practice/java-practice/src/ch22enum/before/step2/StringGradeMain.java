package ch22enum.before.step2;

public class StringGradeMain {
    public static void main(String[] args) {
        DiscountService discountService = new DiscountService();
        int price = 20000;

        //문자열 상수를 사용함으로써, 컴파일 시점에서 오류를 찾을 수 있게됨
        int basicDiscount = discountService.discount(StringGrade.BASIC, price);
        int goldDiscount = discountService.discount(StringGrade.GOLD, price);
        int diamondDiscount = discountService.discount(StringGrade.DIAMOND, price);

        //하지만 문자열 상수가 아닌 문자열 사용이 가능한 상태
        int noneDiscount = discountService.discount("diamond", price);

        System.out.println("BASIC 등급 할인금액: " + basicDiscount + "원");
        System.out.println("GOLD 등급 할인금액: " + goldDiscount + "원");
        System.out.println("DIAMOND 등급 할인금액: " + diamondDiscount + "원");
        System.out.println("diamond 등급 할인금액: " + noneDiscount + "원");
        

    }
}
