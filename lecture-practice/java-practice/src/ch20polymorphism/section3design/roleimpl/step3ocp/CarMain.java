package ch20polymorphism.section3design.roleimpl.step3ocp;


public class CarMain {
    public static void main(String[] args) {
        Driver driver = new Driver();

        driver.setCar(new EV9Car());
        driver.drive();

        driver.setCar(new MX5Car());
        driver.drive();

        driver.setCar(new K8Car());
        driver.drive();

        driver.setCar(new EV3Car());
        driver.drive();
    }
}
