package ch22enum.after.step1enum;


import static ch22enum.after.step1enum.Grade.*;

/* 비즈니스 요구사항
 * 고객은 3등급으로 나누고, 상품 구매 시 등급별로 할인 적용 (할인 시 소수점 이하는 버린다)
 *
 * BASIC -> 10%
 * GOLD -> 20%
 * DIAMOND -> 30%
 * */
public class DiscountService {

    public int discount(Grade grade, int price) {
        int discountPercent = 0;

        if (BASIC.equals(grade)) {
            discountPercent = 10;
        } else if (GOLD.equals(grade)) {
            discountPercent = 20;
        } else if (DIAMOND.equals(grade)) {
            discountPercent = 30;
        } else {
            System.out.println(grade + ": 할인 X");
        }

        return price * discountPercent / 100;
    }

}
