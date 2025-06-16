package ch24nestedclasses.section3local.sub2anonymous.step2example;


import java.util.Random;

// 아래의 메서드들을 하나의 메서드에서 실행할 수 있도록 리팩토링하자
public class Example {

    public static void helloDice() {
        System.out.println("start program"); // 중복되는 부분

        // 코드 조각 시작
        int randomValue = new Random().nextInt(1, 7);
        System.out.println("result: " + randomValue);
        // 코드 조각 종료

        System.out.println("end program");  // 중복되는 부분
    }

    public static void helloSum() {
        System.out.println("start program");  // 중복되는 부분

        // 코드 조각 시작
        for (int i = 0; i < 3; i++) {
            System.out.println("i = " + i);
        }
        // 코드 조각 종료

        System.out.println("end program");  // 중복되는 부분
    }

    public static void main(String[] args) {
        helloDice();
        helloSum();
    }
}
