package ch08scanner.example;

import java.util.HashMap;
import java.util.Scanner;

/* 음식점 주문
 * 음식이름, 가격, 수량을 입력받아 계산출력
 * 총 주문합계: []원.
 * */
public class ScannerEx3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> menu = new HashMap<>();
        menu.put("매콤크림 파스타", 11900);
        menu.put("봉골레 파스타(살짝 매콤)", 11900);
        menu.put("투움바 파스타", 11900);
        menu.put("(스테이크 매콤 크림 파스타))", 16300);

        int sum = 0;
        System.out.println("주문하시겠습니까?");

        while (true) {
            System.out.print("주문메뉴: ");
            String orderMenu = scanner.nextLine();

            if ("end".equals(orderMenu)) {
                break;
            }

            if (!menu.containsKey(orderMenu)) {
                System.out.println("없는 메뉴입니다.");
                continue;
            }
            System.out.print("주문 수량: ");
            int orderServing = scanner.nextInt();
            scanner.nextLine();

            sum += menu.get(orderMenu) * orderServing;
        }
        System.out.println("총 주문합계: " + sum);
        scanner.close();
    }
}
