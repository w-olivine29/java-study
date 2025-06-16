package ch24nestedclasses.section2inner.sub2example.step2after;

public class Car {

    private String model;
    private int chargeLevel;
    private Engine engine;


    public Car(String model, int chargeLevel) {
        this.model = model;
        this.chargeLevel = chargeLevel;
        this.engine = new Engine(); //자신을 생성한 바깥 클래스의 인스턴스 자동참조
    }

    public void start() {
        engine.start();
        System.out.println(model + " starting complete");
    }

    private class Engine {

        public void start() {
            System.out.println("charging level check: " + chargeLevel);
            System.out.println(model + " drive engine");
        }
    }
}
