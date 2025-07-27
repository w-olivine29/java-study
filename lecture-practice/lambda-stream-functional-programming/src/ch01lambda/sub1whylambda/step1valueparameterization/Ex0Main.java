package ch01lambda.sub1whylambda.step1valueparameterization;

// 아래 메서드들을 하나의 메서드로 만들기
// 변하는 부분과 변하지 않는 부분을 분리하자
public class Ex0Main {
    public static void helloJava() {
        System.out.println("프로그램 시작");
        System.out.println("Hello Java");
        System.out.println("프로그램 종료");
    }

    public static void helloSpring() {
        System.out.println("프로그램 시작");
        System.out.println("Hello Spring");
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        helloJava();
        helloSpring();
    }
}
