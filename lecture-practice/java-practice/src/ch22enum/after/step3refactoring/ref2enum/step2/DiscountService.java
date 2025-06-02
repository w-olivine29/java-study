package ch22enum.after.step3refactoring.ref2enum.step2;


/* 비즈니스 요구사항
 * 고객은 3등급으로 나누고, 상품 구매 시 등급별로 할인 적용 (할인 시 소수점 이하는 버린다)
 *
 * BASIC -> 10%
 * GOLD -> 20%
 * DIAMOND -> 30%
 * */
public class DiscountService {

    public int discount(Grade grade, int price) {
        return grade.discount(price);
    }

}
