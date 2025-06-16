package ch20polymorphism.section2.sub2interface.step3hybrid;


public class Duck extends Bird implements Fly, Swim {

    @Override
    public void sound() {
        System.out.println("Duck -> 꽉 꽉 꽉");
    }

    @Override
    public void fly() {
        System.out.println("오리날다");
    }

    @Override
    public void swim() {
        System.out.println("오리수영한다");
    }
    
}
