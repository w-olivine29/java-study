package ch20polymorphism.section3design.roleimpl.step3ocp;

public class EV3Car implements Car {
    @Override
    public void startEngine() {
        System.out.println("EV3Car.startEngine");
    }

    @Override
    public void offEngine() {
        System.out.println("EV3Car.offEngine");

    }

    @Override
    public void pressAccelerator() {
        System.out.println("EV3Car.pressAccelerator");
    }
}
