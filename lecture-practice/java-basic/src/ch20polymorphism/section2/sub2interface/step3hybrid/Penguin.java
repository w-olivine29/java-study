package ch20polymorphism.section2.sub2interface.step3hybrid;


public class Penguin extends Bird implements Swim {

    @Override
    public void sound() {
        System.out.println("Penguin -> aark-aark!");
    }

    @Override
    public void swim() {
        System.out.println("펭귄수영한다");
    }
}

