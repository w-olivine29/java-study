package ch13oop.oop;

/**
 * 전등 제어기
 * 전등을 켜고 끌 수 있다.
 * 전등의 밝기를 조절할 수 있다.
 * 전등의 상태를 확인할 수 있다.
 *
 * 데이터와 기능을 하나로 묶는다.
 * 램프라는 개념의 객체를 지향
 * 램프를 사용하는데 필요한 속성과 기능이 하나의 클래스에 포함
 * 
 * 캡슐화: 속성과 기능을 하나로 묶어서 필요한 기능을 메서드를 통해 외부에 제공하는 것
 */
public class Lamp {

    int lightness;
    boolean isOn;

    void turnOn() {
        isOn = true;
        System.out.println("전등을 켰습니다.");
    }

    void turnOff() {
        isOn = false;
        System.out.println("전등을 껐습니다.");
    }


    void increaseBrightness() {
        lightness++;
    }

    void decreaseBrightness() {
        lightness--;
    }

    void checkStatus() {
        if (isOn) {
            System.out.println("전등 on 상태");
            System.out.println("현재 밝기: " + lightness);
        } else {
            System.out.println("전등 off 상태");
        }
    }
}
