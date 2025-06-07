package ch26generic.section3method;

public class Cat extends Animal {
    public Cat(String name, int weight) {
        super(name, weight);
    }

    @Override
    public void sound() {
        System.out.println("meow");
    }
}
