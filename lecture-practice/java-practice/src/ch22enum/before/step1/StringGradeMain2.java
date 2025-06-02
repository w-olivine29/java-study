package ch22enum.before.step1;

public class StringGradeMain2 {
    public static void main(String[] args) {
        DiscountService discountService = new DiscountService();

        int price = 20000;

        // 실수로 존재하지 않는 등급을 넣을 수도 있다.
        int noneDiscount1 = discountService.discount("DIAMAND", price); // 오타
        int noneDiscount2 = discountService.discount("diamond", price); // 대소문자

        System.out.println("DIAMAND 등급 할인금액: " + noneDiscount1 + "원");
        System.out.println("diamond 등급 할인금액: " + noneDiscount2 + "원");
    }
}
