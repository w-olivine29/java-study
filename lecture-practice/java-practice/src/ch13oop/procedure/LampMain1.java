package ch13oop.procedure;

// 절차지향1 - 시작
public class LampMain1 {
    public static void main(String[] args) {
        int brightness = 0;
        boolean isOn = false;
        
        // 전등 on
        isOn = true;
        System.out.println("전등을 켰습니다.");

        // 밝기 증가
        brightness++;

        // 밝기 증가
        brightness++;
        
        // 전등 상태
        if(isOn){
            System.out.println("전등 on 상태");
            System.out.println("현재 밝기: " + brightness);
        } else {
            System.out.println("전등 off 상태");
        }

        // 밝기 감소
        brightness--;

        // 전등 끄기
        isOn = false;

        if(isOn){
            System.out.println("전등 on 상태");
            System.out.println("현재 밝기: " + brightness);
        } else {
            System.out.println("전등 off 상태");
        }
    }
}
