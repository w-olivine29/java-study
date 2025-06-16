package ch20polymorphism.section3design.example.ex2.answer;

/* 결제 시스템 리팩토링
 * - OCP 원칙
 * - PayMain은 변경하지 않고 진행
 * - 리팩토링 후에도 실행결과는 기존과 같아야함
 *
 * 새로운 결제 수단 추가 시 클라이언트(PayService)의 변경을 최소화하도록 한다.
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

        //google 결제
        String payOption3 = "google";
        int amount3 = 30000;
        payService.processPay(payOption3, amount3);

        //잘못된 결제 수단 선택
        String payOption4 = "bad";
        int amount4 = 15000;
        payService.processPay(payOption4, amount4);

    }

}
