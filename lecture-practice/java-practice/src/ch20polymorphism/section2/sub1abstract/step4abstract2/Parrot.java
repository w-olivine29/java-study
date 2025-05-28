package ch20polymorphism.section2.sub1abstract.step4abstract2;

public class Parrot extends Bird {

    @Override
    public void sound() {
        System.out.println("Parrot -> hello");
    }

    @Override
    public void fly() {
        System.out.println("Parrot flying");
    }
}
