package day5.ex2;

public class Payment {

        void processPayment(int amount) {
            System.out.println("결제 처리: " + amount + "원");
        }

        void refund(int amount) {
            System.out.println("환불 처리: " +amount + "원");
        }
    }


    class TossPaymentMain extends Payment {

        void processPayment(int amount) {
            System.out.println("토스 결제: " +amount + "원");
        }

        void refund(int amount) {
            System.out.println("토스 환불: " + amount + "원");
        }

    }
    class KakaoPaymentMain extends Payment {

        void processPayment(int amount) {
            System.out.println("카카오페이 결제: " + amount + "원");
        }

        void refund(int amount) {
            System.out.println("카카오페이 환불: " + amount + "원");
        }
    }

    class NaverPaymentMain extends Payment {

        void processPayment(int amount) {
            System.out.println("네이버페이 결제: " + amount + "원");
        }

        void refund(int amount) {
            System.out.println("네이버 환불: " + amount + "원");
        }
    }




