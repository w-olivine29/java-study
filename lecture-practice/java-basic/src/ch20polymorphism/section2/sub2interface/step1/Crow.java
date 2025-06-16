package ch20polymorphism.section2.sub2interface.step1;


public class Crow implements Bird {

    @Override
    public void sound() {
        System.out.println("Crow -> caw caw caw");
    }

    @Override
    public void fly() {
        System.out.println("crow flying");
    }
}
