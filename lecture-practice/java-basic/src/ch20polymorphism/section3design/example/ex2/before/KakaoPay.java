package ch20polymorphism.section3design.example.ex2.before;

public class KakaoPay {

    public boolean pay(int amount) {
        System.out.println("connect KakaoPay");
        System.out.println("pay " + amount + "원");
        return true;
    }

}
