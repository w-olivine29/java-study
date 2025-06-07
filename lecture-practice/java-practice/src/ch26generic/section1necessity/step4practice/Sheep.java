package ch26generic.section1necessity.step4practice;

public class Sheep extends Animal {
    public Sheep(String name, int weight) {
        super(name, weight);
    }

    @Override
    public void sound() {
        System.out.println("baa");
    }
}
