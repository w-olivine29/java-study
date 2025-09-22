package day1to3;

public class TypeCastingExample {
    public static void main(String[] args) {

        System.out.println("\n1. [정수 -> 실수] =====================================================");
        int num = 10;
        double doubleNum = (double) num; // 묵시적 형변환  (double 생략가능)
        System.out.println("num = " + num);
        System.out.println("doubleNum = " + doubleNum);



        System.out.println("\n2. [실수 -> 정수] =====================================================");
        double score = 93.7;
        int scoreInt = (int) score; // 명시적 형변환 (int 생략 불가)
        System.out.println("score = " + score);
        System.out.println("scoreInt = " + scoreInt);


        System.out.println("\n3. [논리형 -> x] =====================================================");
        boolean flag = true;
        System.out.println();
        System.out.println("3. 논리형은 형변환 불가");
        System.out.println("flag = " + flag);
        //int boolToInt = (int) flag; // Inconvertible types; cannot cast 'boolean' to 'int'


        System.out.println("\n4. [int <-> char] ASCII =====================================================");

        char c = 'A';
        int charNum = (int) c;
        System.out.println("charNum = " + charNum); //65

        System.out.println();

        num = 66;
        char character = (char) num;
        System.out.println("num = " + num); //66
        System.out.println("character = " + character); //B


        System.out.println("\n1. 업캐스팅 (작은 타입 -> 큰 타입) =====================================================");
        int number = 10;
        double doubleNumber = number; // int -> double 자동 형병환
        System.out.println("int 값 : " + number); // 10
        System.out.println("doubleNumber 값 : " + doubleNumber); // 10.0


        System.out.println("\n2. 다운캐스팅 (큰 타입 -> 작은 타입) =====================================================");
        double doubleScore = 93.7;
        int intScore = (int) doubleScore;
        System.out.println("double 값 : " + doubleScore); // 93.7
        System.out.println("int 값 : " + intScore); // 93

        System.out.println("=== 데이터 손실 ===");
        double pi = 3.14;
        int intPi = (int) pi;
        System.out.println("double 값 : " + pi); // 3.14
        System.out.println("int 값 " + intPi); //3

        int a = 333;
        byte b = (byte) a;
        System.out.println("int = " + a); //333
        System.out.println("b = " + b); //77

    }
}
