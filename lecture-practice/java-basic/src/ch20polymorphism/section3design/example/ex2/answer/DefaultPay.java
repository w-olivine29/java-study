package ch20polymorphism.section3design.example.ex2.answer;

public class DefaultPay implements Pay {
    @Override
    public boolean pay(int amount) {
        System.out.println("존재하지 않는 결제수단입니다.");
        return false;
    }
}
