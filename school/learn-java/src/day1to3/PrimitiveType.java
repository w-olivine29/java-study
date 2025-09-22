package day1to3;

public class PrimitiveType {
    public static void main(String[] args) {
        System.out.println("정수형 ========================================================");

        // [byte] 1바이트    -128 ~ 127  (-2^7 ~ 2^7-1)
        byte byteMinNum =  Byte.MIN_VALUE;
        byte byteMaxNum =  Byte.MAX_VALUE;
        System.out.printf("\n[byte] min, max =  %d, %d", byteMinNum, byteMaxNum);

        // [short] 2바이트   -32768 ~ 32767  (-2^15 ~ 2^15-1)
        short shortMinNum =  Short.MIN_VALUE;
        short shortMaxNum =  Short.MAX_VALUE;
        System.out.printf("\n[short] min, max =  %d, %d", shortMinNum, shortMaxNum);

        // [int] 4바이트   -2_147_483_648 ~ 2_147_483_647  (-2^31 ~ 2^31-1)
        int intMinNum =  Integer.MIN_VALUE;
        int intMaxNum =  Integer.MAX_VALUE;
        System.out.printf("\n[int] min, max =  %d, %d", intMinNum, intMaxNum);


        // [long]  8바이트  -9_223_372_036_854_775_808 ~ 9_223_372_036_854_775_807 (-2^63 ~ 2^63-1)
        long longNum = 1L;
        long longMinNum =  Long.MIN_VALUE;
        long longMaxNum =  Long.MAX_VALUE;
        System.out.printf("\n[long] min, max =  %d, %d", longMinNum, longMaxNum);

        
        System.out.println("\n실수형 ========================================================");
        
        // [float] 4바이트
        // [double] 8바이트
        float floatNum = 3.14f; // 실수형은 f접미사 누락 시 double로 간주
        double doubleNum = 3.14;


        System.out.println("\n문자형 ========================================================");

        // [char] 2바이트
        char grade = 'a'; // 작은따옴표와 문자 하나를 넣어야함


        System.out.println("\n논리형 ========================================================");
        
        // [boolean] 1바이트
        boolean isPass = true;
        boolean isPass2 = false;
        
        //==============================================================================================================

        // 문자열
        String name = "zero";
        String prefix = "Z";

        // 레퍼런스 타입
        // 1. 문자열 변환이 필요할 때
        String strNum = "25";

        // 문자열 -> 숫자
        int intNum = Integer.parseInt(strNum);
        System.out.println(intNum);

        // 기본형 -> 레퍼런스 타입
        Integer integerNum = Integer.valueOf(strNum);
        System.out.println(integerNum);

        // 레퍼런스 타입은 null을 허용
        Integer num = null;
        System.out.println(num);
        

        int number = 42;
        System.out.println("2진수로 변환 : " + Integer.toBinaryString(number));
        System.out.println("16진수로 변환 : " + Integer.toHexString(number));

        // 박싱 & 언박싱
        int a = 5;
        Integer bb = new Integer(a); //'Integer(int)' is deprecated since version 9 and marked for removal
        System.out.println("박싱 : " + bb);

        // 언박싱
        Integer b = new Integer(5); //'Integer(int)' is deprecated since version 9 and marked for removal
        int bbb = b.intValue();
        System.out.println("언박싱 : " + bbb);

        // after JDK5)  오토 박싱 & 오토 언박싱 지원
        int aaa = 5;
        Integer aaa2 = aaa; // 오토 박싱
        System.out.println("오토 박싱 : " + aaa2);

        int c = aaa2; // 오토언박싱
        System.out.println("오토 언박싱 : " + c);

    }
}
