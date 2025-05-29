package ch20polymorphism.section3design.roleimpl.step1start;

public class CarMain {
    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.setEv9Car(new EV9Car());

        driver.drive();
    }
}
