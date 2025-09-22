package day5.ex4;

// 할인 x (Null Object 패턴 적용)
public class DefaultDiscountPolicy implements DiscountPolicy {

    @Override
    public int calculateDiscount(int price) {
        return 0;
    }
}
