package ch07casting;

public class Casting03Overflow {
    public static void main(String[] args) {


        System.out.println("=== 오버플로우 ===================================");
        //int maxIntValue = 2147483648; // Integer number too large (컴파일 에러)

        // 바로 표현범위를 넘어선 수를 넣으면 컴파일러가 에러를 내지만  (리터럴 해석 불가)
        // 아래와 같은 경우 연산 후 오버플로우 허용 (예외를 던지지 않고 순환)
        long maxIntOver = Integer.MAX_VALUE + 1;
        System.out.println("maxIntOver = " + maxIntOver); // -2147483648


        System.out.println("=== 명시적 형변환 -> 오버플로우 =================================== ");
        maxIntOver = (long)Integer.MAX_VALUE + 3; //2147483650
        System.out.println("[long] -> maxIntOver = " + maxIntOver);
        
        // 이 경우 명시적 형변환이 필요
        // int intValue = maxIntOver;  // incompatible types: possible lossy conversion from long to int

        int intValue = (int)maxIntOver;
        System.out.println("[long -> int] intValue = " + intValue); //-2147483646

    }
}
