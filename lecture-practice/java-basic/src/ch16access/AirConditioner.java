package ch16access;

/**
 * 최대 설정온도 32, 최소 설정온도 16도라는 조건이 있다.
 */
public class AirConditioner {


    // private: 해당 클래스 내부에서만 호출 가능
    // 제약조건이 있어야할 필드가 외부에서 직접 접근할 수 있는 상황이 되어선 안된다.
    private int temperature;

    public AirConditioner(int temperature) {
        this.temperature = temperature;
    }

    void upTemperature() {

        if (temperature >= 32) {
            System.out.println("최대 설정온도는 32도입니다.");
        } else {
            this.temperature++;
            System.out.print("온도를 1도 올립니다 ->");
        }

        showTemperature();
    }

    void downTemperature() {

        if (temperature <= 16) {
            System.out.print("최소 설정온도는 16도입니다. ");
        } else {
            this.temperature--;
            System.out.print("온도를 1도 내립니다 ->");
        }

        showTemperature();

    }

    void showTemperature() {
        System.out.println("[현재 온도: " + temperature + "도]");
    }

}


