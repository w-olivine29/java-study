package ch26generic.section3method.step2practice;


import ch26generic.section3method.Animal;

public class AnimalMethod {

    public static <T extends Animal> void checkup(T t) {
        System.out.println("name: " + t.getName());
        System.out.println("weight: " + t.getWeight());
    }

    public static <T extends Animal> T heavierThan(T t1, T t2) {
        return t1.getWeight() > t2.getWeight() ? t1 : t2;
    }
}
