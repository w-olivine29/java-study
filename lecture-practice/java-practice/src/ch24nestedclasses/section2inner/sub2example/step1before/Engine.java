package ch24nestedclasses.section2inner.sub2example.step1before;

// Car에서만 사용
public class Engine {

    private Car car;

    public Engine(Car car) {
        this.car = car;
    }

    public void start() {
        System.out.println("charging level check: " + car.getChargeLevel());
        System.out.println(car.getModel() + " drive engine");
    }
}
