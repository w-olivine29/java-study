package mission.week1.optionaltask.task1;

import java.util.Scanner;

/* 과제1) 결제 금액 캐시백 계산 프로그램
직불카드로 결제를 하게되면 이에 대한 캐시백을 제공

캐시백 계산 조건
    결제 금액의 10%를 적립한다.
    캐시백포인트 단위는 백원단위이다.(100원, 200원, 300원 등)
    한건의 캐시백 포인트는 최대 300원을 넘을 수 없습니다
*/

public class CashBackMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[캐시백 계산]");
        int paymentAmount = 0;
        while (true){
            try{
                System.out.print("결제 금액을 입력해 주세요 (금액): ");
                paymentAmount = Integer.parseInt(scanner.nextLine());
                break;
            }catch (NumberFormatException e){
                System.out.println("제대로 된 금액을 입력해주세요!");
            }
        }

        System.out.printf("결제 금액: %d원, 캐시백: %d원", paymentAmount, calculateCashBack(paymentAmount));
    }

    private static int calculateCashBack(int paymentAmount) {
        int cashback = (paymentAmount / 10) / 100 * 100; // int 끼리의 계산에서 소숫점이 소실되는 것을 활용
        return Math.min(cashback, 300); // 300원이 넘어간다면 300원 반환
    }
}
