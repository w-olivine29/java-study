package ch20polymorphism.section3design.example.ex2.after;

public class PayService {

    private final PaymentStore paymentStore;


    public PayService() {
        paymentStore = new PaymentStore();
    }

    public void processPay(String option, int amount) {

        System.out.println("\n[결제] option=" + option + ", amount=" + amount);


        // ocp원칙 위반 부분
//        if (option.equals("kakao")) {
//            KakaoPay kakaoPay = new KakaoPay();
//            result = kakaoPay.pay(amount);
//        } else if (option.equals("naver")) {
//            NaverPay naverPay = new NaverPay();
//            result = naverPay.pay(amount);
//        } else {
//            System.out.println("결제 수단이 없습니다.");
//            result = false;
//        }

        Pay paymentOption = paymentStore.getPaymentOption(option);

        if (paymentOption == null) {
            System.out.println("결제실패 [존재하지 않는 결제옵션입니다.]");
            return;
        }

        if (!paymentOption.pay(amount)) {
            System.out.println("결제실패 [고객센터에 문의]");
        }

        System.out.println("결제 완료");

    }

}