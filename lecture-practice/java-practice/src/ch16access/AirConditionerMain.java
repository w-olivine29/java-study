package ch16access;

public class AirConditionerMain {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner(19);
        airConditioner.showTemperature();

        airConditioner.downTemperature();
        airConditioner.downTemperature();
        airConditioner.downTemperature();
        airConditioner.downTemperature();

        airConditioner.showTemperature();


        // 제약조건이 있어야할 필드가 외부에서 직접 접근할 수 있는 상황
        System.out.println("==== 필드에 직접 접근하여 온도값 수정 ========");
        airConditioner.temperature = -5;
        airConditioner.showTemperature();

    }


}
