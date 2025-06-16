package ch20polymorphism.section3design.roleimpl.step2;


public class CarMain {
    public static void main(String[] args) {
        Driver driver1 = new Driver();

        driver1.setEv9Car(new EV9Car());
        driver1.setMx5Car(new MX5Car());
        driver1.drive();

        Driver driver2 = new Driver();
        driver2.setMx5Car(new MX5Car());
        driver2.drive();
    }
}
