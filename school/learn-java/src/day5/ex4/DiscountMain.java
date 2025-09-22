package day5.ex4;

public class DiscountMain {

    public static void main(String[] args) {
        
        // 상품들에 할인정책 적용
        Product product1 = new Product("적축 키보드", 100_000, new PercentDiscountPolicy()); // 정률 할인 정책 적용
        Product product2 = new Product("블루투스 마우스", 30_000, new FixedDiscountPolicy()); // 정액 할인 정책 적용
        Product product3 = new Product("고불소 치약", 10_000, new DefaultDiscountPolicy()); // 할인 x (Null Object 패턴 적용)

        // 상품 정보 출력
        System.out.println("=== 정률 할인 적용 ===");
        product1.printInfo();
        System.out.println();

        System.out.println("=== 정액 할인 적용 ===");
        product2.printInfo();
        System.out.println();

        System.out.println("=== 할인 x ===");
        product3.printInfo();
        System.out.println();
    }
}
