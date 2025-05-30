package ch21lang.section2immutable.step1start;

public class PrimitiveMain {
    public static void main(String[] args) {
        // 기본형은 절대로 같은 값을 공유하지 않는다
        int a = 10;
        int b = a; // a의 값을 복사 -> b에 대입
        System.out.println("b = a = 10");
        System.out.println("a = " + a); //10
        System.out.println("b = " + b); //10

        b = 20;
        System.out.println("\nb = 20");
        System.out.println("a = " + a); //10
        System.out.println("b = " + b); //20
    }
}
