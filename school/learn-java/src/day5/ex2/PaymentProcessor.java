package day5.ex2;

public class PaymentProcessor {

    void processPayment(Payment payment, int amount) {
        System.out.println("==== 결제 시작 ====");
        payment.processPayment(amount);
        System.out.println("==== 결제 완료 ====");
    }
}
