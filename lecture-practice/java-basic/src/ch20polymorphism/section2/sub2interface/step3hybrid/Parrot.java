package ch20polymorphism.section2.sub2interface.step3hybrid;


public class Parrot extends Bird implements Fly {

    @Override
    public void sound() {
        System.out.println("Parrot -> hello");
    }

    @Override
    public void fly() {
        System.out.println("Parrot flying");
    }
}
