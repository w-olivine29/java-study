package ch13oop.procedure;

// 절차지향2 - 데이터묶음
public class LampMain2 {
    public static void main(String[] args) {

        // LampData 라는 클래스 데이터를 하나로 관리
        Lamp lamp = new Lamp();

        // 전등 on
        lamp.isOn = true;
        System.out.println("전등을 켰습니다.");

        // 밝기 증가
        lamp.lightness++;

        // 밝기 증가
        lamp.lightness++;

        // 전등 상태
        if (lamp.isOn) {
            System.out.println("전등 on 상태");
            System.out.println("현재 밝기: " + lamp.lightness);
        } else {
            System.out.println("전등 off 상태");
        }

        // 밝기 감소
        lamp.lightness--;

        // 전등 끄기
        lamp.isOn = false;
        System.out.println("전등을 껐습니다.");

        if (lamp.isOn) {
            System.out.println("전등 on 상태");
            System.out.println("현재 밝기: " + lamp.lightness);
        } else {
            System.out.println("전등 off 상태");
        }
    }
}
