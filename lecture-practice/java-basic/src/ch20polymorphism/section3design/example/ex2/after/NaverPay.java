package ch20polymorphism.section3design.example.ex2.after;

public class NaverPay implements Pay {

    @Override
    public boolean pay(int amount) {
        System.out.println("connect NaverPay");
        System.out.println("pay " + amount + "원");
        return true;
    }
}
