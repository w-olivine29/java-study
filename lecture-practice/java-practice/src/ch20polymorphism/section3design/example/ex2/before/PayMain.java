package ch20polymorphism.section3design.example.ex2.before;

/* 결제 시스템 리팩토링 규칙
 * - OCP 원칙
 * - PayMain은 변경하지 않고 진행
 *
 * 새로운 결제 수단 추가 시 클라이언트(PayService)의 변경을 최소화되도록 한다.
 * */
public class PayMain {

    public static void main(String[] args) {

        PayService payService = new PayService();

        //kakao 결제
        String payOption1 = "kakao";
        int amount1 = 5000;
        payService.processPay(payOption1, amount1);

        //naver 결제
        String payOption2 = "naver";
        int amount2 = 10000;
        payService.processPay(payOption2, amount2);

        //잘못된 결제 수단 선택
        String payOption3 = "bad";
        int amount3 = 15000;
        payService.processPay(payOption3, amount3);
    }

}
