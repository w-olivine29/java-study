package ch26generic.section2typebound.step2polymorphism;

import ch26generic.section2typebound.Animal;

public class AnimalHospital2 {

    private Animal animal;

    public void set(Animal animal) {
        this.animal = animal;
    }

    public Animal get() {
        return animal;
    }

    public void checkup() {
        System.out.println("name: " + animal.getName());
        System.out.println("weight: " + animal.getWeight());
    }

    public Animal heavierThan(Animal target) {
        return animal.getWeight() > target.getWeight() ? animal : target;
    }
}
