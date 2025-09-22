package day1to3;

public class VariableExample {


    static final int MAX_VALUE = 100;

    public static void main(String[] args) {

        // 1. 변수 선언 & 초기화
        int number; // 변수 선언
        number = 10; // 변수 초기화
        System.out.println("number = " + number);

        int score = 100; // 동시에 변수 선언 & 초기화
        System.out.println("score = " + score);


        // 2. 변수 값 재정의
        score = 80;
        System.out.println("score = " + score);

        // 3. 상수 선언 & 초기화
        //MAX_VALUE = 200; //Cannot assign a value to final variable 'MAX_VALUE'
        
        // 4. 잘못된 변수 선언 예시 (IDE 에서 오류 보여줌)
        //int 1number; //숫자 시작 불가
        //int for; //Identifier expected (예역어 사용불가)
        //int my score; //공백 불가
        //int #number; //특수 문자 불가 (but $, _ 는 제외)

        //5. 올바른 변수명 예시
        int number1;
        int forLoop;
        int myScore;
        int $_number;
    }
}
