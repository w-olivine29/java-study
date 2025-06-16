package ch20polymorphism.section3design.example.ex2.answer;

public class PayService {

//    private final PaymentStore paymentStore;


    public void processPay(String option, int amount) {

        System.out.println("\n[결제] option=" + option + ", amount=" + amount);

        Pay paymentOption = PaymentStore.getPaymentOption(option);

//        if (paymentOption == null) {
//            System.out.println("결제실패 [존재하지 않는 결제옵션입니다.]");
//            return;
//        }

        if (!paymentOption.pay(amount)) {
            System.out.println("결제실패 [고객센터에 문의]");
            return;
        }

        System.out.println("결제 완료");

    }

}