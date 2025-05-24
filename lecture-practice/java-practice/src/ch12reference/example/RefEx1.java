package ch12reference.example;

import java.util.Scanner;

/**
 * 상품 주문 시스템
 * - 주문수량
 * - 가격, 수량, 상품명 입력
 * - 입력 시 상품 순서를 알 수 있게 "n번 째 주문 정보 입력" 출력
 * - 입력완료 시 등록한 상품과 총 결제 금액 출력
 */
public class RefEx1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("입력할 주문 개수: ");

        ProductOrder[] productOrders = new ProductOrder[scanner.nextInt()];
        scanner.nextLine();

        for (int i = 0; i < productOrders.length; i++) {
            ProductOrder productOrder = new ProductOrder();

            System.out.println((i + 1) + "번째 주문 정보 입력");

            System.out.print("상품명: ");
            productOrder.name = scanner.nextLine();

            System.out.print("가격: ");
            productOrder.price = scanner.nextInt();

            System.out.print("수량: ");
            productOrder.quantity = scanner.nextInt();

            productOrders[i] = productOrder;
            scanner.nextLine();
        }

        getTotalAmount(productOrders);
        scanner.close();

    }

    static void getTotalAmount(ProductOrder[] productOrders) {
        int totalAmount = 0;
        for (ProductOrder productOrder : productOrders) {
            productOrder.printInfo();
            totalAmount += productOrder.price * productOrder.quantity;
        }
        System.out.println("총 결제 금액: " + totalAmount);
    }


}

class ProductOrder {
    String name;
    int price;
    int quantity;

    void printInfo() {
        System.out.printf("상품명: %s, 가격: %d, 수량: %d\n",
                name, price, quantity
        );
    }

}
