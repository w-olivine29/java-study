package ch26generic.section2typebound.step1start;

import ch26generic.section2typebound.Wolf;

public class WolfHospital {

    private Wolf wolf;

    public void set(Wolf wolf) {
        this.wolf = wolf;
    }

    public Wolf get() {
        return wolf;
    }

    public void checkup() {
        System.out.println("name: " + wolf.getName());
        System.out.println("weight: " + wolf.getWeight());
    }

    public Wolf heavierThan(Wolf target) {
        return wolf.getWeight() > target.getWeight() ? wolf : target;
    }
}
