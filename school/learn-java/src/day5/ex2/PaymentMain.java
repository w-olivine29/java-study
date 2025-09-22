package day5.ex2;



public class PaymentMain {

    public static void main(String[] args) {
        // 결제 프로세서 생성
        PaymentProcessor processor = new PaymentProcessor();

        // 결제 방식 생성
        Payment tossPayment = new TossPaymentMain();
        Payment kakaoPayment = new KakaoPaymentMain();
        Payment naverPayment = new NaverPaymentMain();

        // 결제 처리
        processor.processPayment(tossPayment, 50000);
        System.out.println();
        processor.processPayment(kakaoPayment, 30000);
        System.out.println();
        processor.processPayment(naverPayment, 20000);

    }
}
