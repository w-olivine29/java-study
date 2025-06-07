package ch26generic.section2typebound.step1start;

import ch26generic.section2typebound.Cat;

public class CatHospital {

    private Cat cat;

    public void set(Cat cat) {
        this.cat = cat;
    }

    public Cat get() {
        return cat;
    }

    public void checkup() {
        System.out.println("name: " + cat.getName());
        System.out.println("weight: " + cat.getWeight());
    }

    public Cat heavierThan(Cat target) {
        return cat.getWeight() > target.getWeight() ? cat : target;
    }
}
