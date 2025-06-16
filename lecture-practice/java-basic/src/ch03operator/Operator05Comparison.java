package ch03operator;

public class Operator05Comparison {
    public static void main(String[] args) {

        System.out.println("=== 숫자 비교 ============================");
        int num1 = 1;
        int num2 = 2;
        System.out.println("num1 == num2 -> " + (num1 == num2));
        System.out.println("num1 != num2 -> " + (num1 != num2));
        System.out.println("num1 > num2 -> " + (num1 > num2));
        System.out.println("num1 > num2 -> " + (num1 > num2));
        System.out.println("num1 >= num2 -> " + (num1 >= num2));
        System.out.println("num1 <= num2 -> " + (num1 <= num2));

        boolean result = num1 == num2;
        System.out.println("result = " + result);

        System.out.println(" === 문자 비교 ============================");
        char c1_1 = 48;
        char c1_2 = '0';

        char c2_1 = 49;
        char c2_2 = '1';
        System.out.println("c1_1 == c1_2 -> " + (c1_1 == c1_2) ); // true
        System.out.println("c1_1 == c2_1 -> " + (c1_1 == c2_1) ); // false


        System.out.println("=== 문자열 비교 ============================");
        // 문자열의 경우 == 연산이 가능하지만 equals를 사용 (객체, 문자열 관련 챕터 참고)
        String str1 = "문자열1";
        String str2 = "문자열2";

        boolean result1 = "string".equals("string"); // 리터럴 비교
        boolean result2_1 = str1.equals("문자열1"); // 변수, 리터럴 비교
        boolean result2_2 = str1 == "문자열1";

        boolean result3_1 = str1.equals(str2); // 변수끼리 비교
        boolean result3_2 = str1 == str2; // 변수끼리 비교

        System.out.println("result1 = " + result1); //true
        System.out.println("result2_1 = " + result2_1); // true
        System.out.println("result2_2 = " + result2_2); // true
        System.out.println("result3_1 = " + result3_1); // false
        System.out.println("result3_2 = " + result3_2); // false

    }
}
