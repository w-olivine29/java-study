package ch09array.example;

import java.util.Scanner;

/**
 * 상품 관리 프로그램
 * 상품 등록: 상품 이름과 가격 입력받아 저장
 * 상품 목록: 등록된 모든 상품 목록 출력
 * <p>
 * "1.상품 등록 ", "2.상품 목록", "3.종료" 를 제시
 * 1번 선택 시 상품이름과 가격을 입력받아 배열에 저장
 * 2번 선택 시 배열에 저장된 모든 상품 출력
 * 3번 선택 시 프로그램 종료
 * <p>
 * 상품은 최대 등록 개수 조건이 있음
 */
public class ArrayEx6 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int maxCnt = 5;
        int cnt = 0;

        String[] names = new String[maxCnt];
        int[] prices = new int[maxCnt];


        while (true) {
            System.out.println("[1]상품 등록  [2]상품 목록  [3]종료");

            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 3) {
                System.out.println("종료");
                break;

            } else if (option == 1) {
                System.out.println("========= 상품 등록 ========= ");
                if (cnt >= names.length) {
                    System.out.println("등록 가능 상품개수 초과");
                    continue;
                }
                System.out.print("상품 이름 입력: ");
                names[cnt] = scanner.nextLine();

                System.out.print("상품 가격 입력: ");
                prices[cnt] = scanner.nextInt();

                cnt++;


            } else if (option == 2) {
                System.out.println("========= 등록한 상품 목록 ========= ");

                if (names[0] == null) {
                    System.out.println("등록된 상품이 없습니다.");
                    continue;

                }
                for (int i = 0; i < names.length; i++) {
                    if (names[i] == null) {
                        break;
                    }
                    System.out.printf("%s: %d원\n", names[i], prices[i]);
                }


            } else {
                System.out.println("옵션을 다시 선택해주세요.");
            }

        }

    }
}
