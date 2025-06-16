package ch20polymorphism.section3design.example.ex2.answer;

public class GooglePay implements Pay {
    @Override
    public boolean pay(int amount) {
        System.out.println("connect GooglePay");
        System.out.println("pay " + amount + "원");
        return true;
    }
}
