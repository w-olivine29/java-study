package ch20polymorphism.section3design.example.ex2.after;

public class KakaoPay implements Pay {

    @Override
    public boolean pay(int amount) {
        System.out.println("connect KakaoPay");
        System.out.println("pay " + amount + "원");
        return true;
    }

}
