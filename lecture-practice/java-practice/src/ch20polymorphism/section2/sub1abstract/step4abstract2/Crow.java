package ch20polymorphism.section2.sub1abstract.step4abstract2;

public class Crow extends Bird {

    @Override
    public void sound() {
        System.out.println("Crow -> caw caw caw");
    }

    @Override
    public void fly() {
        System.out.println("crow flying");
    }
}
