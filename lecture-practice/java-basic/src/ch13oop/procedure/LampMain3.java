package ch13oop.procedure;

// 절차지향3 - 데이터묶음, 메서드 추출

/**
 * 각각의 기능을 메서드화 -> 각각의 기능이 모듈화 -> LampMain2보다는 유지보수 up
 *
 * but)
 * 데이터와 기능이 분리된 상태
 * 유지보수 시 관리포인트가 2개 (LampData 의 데이터 수정 시 -> 분리 돼있는 메서드들을 다 고쳐야함)
 */
public class LampMain3 {
    public static void main(String[] args) {

        Lamp lamp = new Lamp();

        turnOn(lamp);

        increaseBrightness(lamp);

        increaseBrightness(lamp);
        
        checkStatus(lamp);

        decreaseBrightness(lamp);

        turnOff(lamp);

        checkStatus(lamp);
    }

    static void turnOn(Lamp lamp) {
        lamp.isOn = true;
        System.out.println("전등을 켰습니다.");
    }

    static void turnOff(Lamp lamp) {
        lamp.isOn = false;
        System.out.println("전등을 껐습니다.");
    }

    static void increaseBrightness(Lamp lamp) {
        lamp.lightness++;
    }

    static void decreaseBrightness(Lamp lamp) {
        lamp.lightness--;
    }

    static void checkStatus(Lamp lamp) {
        if (lamp.isOn) {
            System.out.println("전등 on 상태");
            System.out.println("현재 밝기: " + lamp.lightness);
        } else {
            System.out.println("전등 off 상태");
        }
    }
}
