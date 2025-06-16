package ch20polymorphism.section3design.example.ex2.after;

public class PaymentStore {


    public Pay getPaymentOption(String option) {

        if (option.equals("kakao")) {
            return new KakaoPay();
        }
        if (option.equals("naver")) {
            return new NaverPay();
        }
        if (option.equals("google")) {
            return new GooglePay();
        }

        return null;
    }
}
