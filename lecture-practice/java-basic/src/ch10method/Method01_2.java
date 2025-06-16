package ch10method;

public class Method01_2 {

    public static void main(String[] args) {
        printHeader();
        printFooter();
    }


    // 매개변수 X, 반환타입 X
    static void printHeader() {
        System.out.println("==== 프로그램 시작 ====");
        return; // 반환타입이 없는경우 return문 생략 가능 (컴파일러가 붙여줌)
    }

    static void printFooter() {
        System.out.println("==== 프로그램 종료 ====");
    }


}
