package ch26generic.section2typebound;

public class Wolf extends Animal {


    public Wolf(String name, int weight) {
        super(name, weight);
    }

    @Override
    public void sound() {
        System.out.println("howl");
    }
}
