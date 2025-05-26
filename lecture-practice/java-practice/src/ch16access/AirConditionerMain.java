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


        // 해당 필드를 private 로 변경함으로써 외부에서 접근 불가
        System.out.println("==== 필드에 직접 접근하여 온도값 수정 ========");
        //airConditioner.temperature = -5; // java: temperature has private access in ch16access.AirConditioner
        airConditioner.showTemperature();

    }


}
