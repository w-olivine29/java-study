package ch20polymorphism.section2.sub1abstract.step4abstract2;


public class Sparrow extends Bird {

    @Override
    public void sound() {
        System.out.println("Sparrow -> chirp chirp ");
    }

    @Override
    public void fly() {
        System.out.println("Sparrow flying");
    }
}

