package ch20polymorphism.section3design.roleimpl.step3ocp;

public class EV9Car implements Car {

    @Override
    public void startEngine() {
        System.out.println("EV9Car.startEngine");
    }

    @Override
    public void offEngine() {
        System.out.println("EV9Car.offEngine");
    }

    @Override
    public void pressAccelerator() {
        System.out.println("EV9Car.pressAccelerator");
    }
}
