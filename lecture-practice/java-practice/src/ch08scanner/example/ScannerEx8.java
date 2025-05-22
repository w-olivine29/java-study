package ch08scanner.example;

import java.util.Scanner;

/* 상품 구매
 * 사용자로부터 상품정보(상품명, 가격, 수량)을 입력받고, 총 가격을 출력
 *
 * 세 가지 옵션 제공
 * 1.상품 입력, 2.결제, 3.프로그램 종료 (옵션은 정수로 입력받기)
 * 결제옵션 선택 시 총 비용 지불 후 0으로 초기화
 * 제공된 외의 옵션 선택 시 올바른 옵션을 선택해주세요 출력
 * */
public class ScannerEx8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalCost = 0;
        while (true) {
            System.out.println("1.상품 입력, 2.결제, 3.프로그램 종료");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.print("상품명: ");
                String itemName = scanner.nextLine();

                System.out.print("가격: ");
                int price = scanner.nextInt();

                System.out.print("수량: ");
                int quantity = scanner.nextInt();

                totalCost += price * quantity;

            } else if (option == 2) {

                System.out.println("결제금액: " + totalCost);
                totalCost = 0;

            } else if (option == 3) {

                if (totalCost == 0) {
                    scanner.close();
                    break;
                }
                System.out.println("결제해야할 품목이 있습니다.");

            } else {
                System.out.println("올바른 옵션을 선택해주세요");
            }
        }
    }
}
