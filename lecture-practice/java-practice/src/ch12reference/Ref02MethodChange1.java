package ch12reference;

public class Ref02MethodChange1 {
    public static void main(String[] args) {
        int num = 10;

        System.out.println("=== 메서드 호출 전: num = " + num); //10

        changePrimitive(num); // num 에 있는 값을 복사해서 인수로 넘김

        System.out.println("=== 메서드 호출 후: num = " + num); //10

    }

    static void changePrimitive(int num) { // 인수로 넘어온 값을 해당 파라미터에 대입
        num = 100; // 해당 메서드의 파라미터 값을 새로 대입
    }
}
