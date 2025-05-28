package ch20polymorphism.section2.sub2interface.step1;


public class Parrot implements Bird {

    @Override
    public void sound() {
        System.out.println("Parrot -> hello");
    }

    @Override
    public void fly() {
        System.out.println("Parrot flying");
    }
}
