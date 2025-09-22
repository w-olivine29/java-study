package day5.ex4;

public class Product {

    private String name; // 상품명
    private int price; // 가격
    private DiscountPolicy discountPolicy;

    public Product(String name, int price, DiscountPolicy discountPolicy) { // 다형성 적용
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    // 할인된 가격 계산
    public int getDiscountPrice() {
        return price - discountPolicy.calculateDiscount(price);
    }

    public void printInfo() {
        System.out.println("상품명: " + name);
        System.out.println("원가: " + price + "원");
        System.out.println("할인 금액: " + discountPolicy.calculateDiscount(price) + "원");
        System.out.println("할인된 가격 : " + getDiscountPrice() + "원");
    }
}
