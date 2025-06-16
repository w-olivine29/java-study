package ch10method;

public class Method03Casting {
    public static void main(String[] args) {
        double doubleNum = 1.5;
        int intNum = 1;

        printInt((int) doubleNum); // 명시적 형변환
        printDouble(intNum); // 자동 형변환

    }

    static void printInt(int num) {
        System.out.println("숫자: " + num);
    }
    static void printDouble(double num) {
        System.out.println("숫자: " + num);
    }
}
