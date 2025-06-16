package ch13oop.oop;

public class LampMain {
    public static void main(String[] args) {

        // 램프 객체 생성 후 필요한 기능을 호출만 하면 됨
        Lamp lamp = new Lamp();
        lamp.turnOn();
        lamp.checkStatus();

        lamp.increaseBrightness();
        lamp.increaseBrightness();
        lamp.increaseBrightness();
        lamp.increaseBrightness();

        lamp.checkStatus();

        lamp.turnOff();
    }
}
