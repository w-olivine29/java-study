package ch24nestedclasses.section2inner.sub2example.step1before;

/*
 * Engine에서만 사용할 기능을 위해 메서드를 추가하면서
 * 모델 이름, 충전 레벨 등의 정보가 외부에 노출됨
 * → car 클래스의 내부 정보가 외부로 노출되어 캡슐화 수준이 저하됨
 */
public class Car {

    private String model;
    private int chargeLevel;
    private Engine engine;

    public Car(String model, int chargeLevel) {
        this.model = model;
        this.chargeLevel = chargeLevel;
        engine = new Engine(this);
    }

    // Engine 에서만 사용하는 메서드
    public int getChargeLevel() {
        return chargeLevel;
    }

    // Engine 에서만 사용하는 메서드
    public String getModel() {
        return model;
    }

    public void start() {
        engine.start();
        System.out.println(model + " starting complete");
    }
}
