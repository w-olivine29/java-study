package ch20polymorphism.section3design.roleimpl.step3ocp;


public class K8Car implements Car {
    @Override
    public void pressAccelerator() {
        System.out.println("K8Car.pressAccelerator");
    }

    @Override
    public void offEngine() {
        System.out.println("K8Car.offEngine");
    }

    @Override
    public void startEngine() {
        System.out.println("K8Car.startEngine");

    }
}
