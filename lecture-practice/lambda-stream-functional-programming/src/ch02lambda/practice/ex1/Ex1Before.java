package ch02lambda.practice.ex1;

/* 중복되는 메시지 출력 로직 리팩토링
중복되는 코드 제거, 변하는 부분만 매개변수로 받도록 리팩토링하기
*/
public class Ex1Before {

    public static void greetMorning() {
        System.out.println("=== 시작 ===");
        System.out.println("Good Morning!");
        System.out.println("=== 끝 ===");
    }

    public static void greetAfternoon() {
        System.out.println("=== 시작 ===");
        System.out.println("Good Afternoon!");
        System.out.println("=== 끝 ===");
    }

    public static void greetEvening() {
        System.out.println("=== 시작 ===");
        System.out.println("Good Evening!");
        System.out.println("=== 끝 ===");
    }

    public static void main(String[] args) {
        greetMorning();
        greetAfternoon();
        greetEvening();
    }
}