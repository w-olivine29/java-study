package ch07casting;

public class Casting02Explicit {
    public static void main(String[] args) {
        double doubleValue = 8.29;
        int intValue = 0;

        //intValue = doubleValue; // 컴파일에러

        intValue = (int) doubleValue; // 명시적으로 형변환 (doubleValue 에서 읽은 값을 형변환)
        System.out.println("intValue = " + intValue); //8

        // doubleValue 은 그대로 8.29
        // 대입연산자를 쓸 때만 변경된다
        System.out.println("doubleValue = " + doubleValue);


    }
}
