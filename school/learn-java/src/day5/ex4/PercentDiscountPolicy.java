package day5.ex4;

// 정률 할인 정책 구현 (10% 할인)
public class PercentDiscountPolicy implements DiscountPolicy {

    @Override
    public int calculateDiscount(int price) {
        return (int)(price * 0.1); // 10% 할인
    }
}
