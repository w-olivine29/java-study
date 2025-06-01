package ch21lang.example.ex3;

// 문자열 -> Integer
// Integer -> int
// int -> Integer
// 조건) 자동변환
public class Example3_2 {
    public static void main(String[] args) {
        String str = "500";

        // 문자열 -> Integer
        Integer integer = Integer.valueOf(str);
        System.out.println("integer = " + integer);

        // Integer -> int
        int intValue = integer;
        System.out.println("intValue = " + intValue);

        // int -> Integer
        Integer result = intValue;
        System.out.println("result = " + result);
    }
}
