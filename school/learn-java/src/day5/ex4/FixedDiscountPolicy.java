package day5.ex4;

// 정액 할인 정책 구현 (1000원 할인)
public class FixedDiscountPolicy implements DiscountPolicy {

    @Override
    public int calculateDiscount(int price) {
        return 1000;
    }
}
