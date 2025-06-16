package ch20polymorphism.section2.sub2interface.step1;


public class Sparrow implements Bird {

    @Override
    public void sound() {
        System.out.println("Sparrow -> chirp chirp ");
    }

    @Override
    public void fly() {
        System.out.println("Sparrow flying");
    }
}

