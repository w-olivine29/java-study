package ch20polymorphism.section3design.roleimpl.step3ocp;

public class MX5Car implements Car {

    @Override
    public void startEngine() {
        System.out.println("MX5Car.startEngine");
    }

    @Override
    public void offEngine() {
        System.out.println("MX5Car.offEngine");
    }

    @Override
    public void pressAccelerator() {
        System.out.println("MX5Car.pressAccelerator");
    }
}
