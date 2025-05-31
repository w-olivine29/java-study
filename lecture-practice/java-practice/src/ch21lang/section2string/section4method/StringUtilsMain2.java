package ch21lang.section2string.section4method;

public class StringUtilsMain2 {
    public static void main(String[] args) {
        int num = 100;
        boolean bool = true;
        String str = "Hello, Java!";

        // String.format
        String format1 = String.format("num: %d, bool: %b string: %s", num, bool, str);
        System.out.println("format1: " + format1);
        System.out.printf("num: %d, bool: %b string: %s\n", 500, bool, str);

        // 실수
        System.out.println(String.format("%.3f", 1234.653414113)); // 1234.653  //Redundant call
        // 정수
        System.out.printf("%03d\n", 20); //"010"
        System.out.printf("%3d\n", 20); // " 10"


        // matches (정규표현식 사용)
        String regex = "Hello (Java!|CS!)"; // 앞에 "Hello "가 오고 뒤에는 Java! or CS! 이 오는 정규식
        System.out.println("패턴 일치여부: " + str.matches(regex)); //false

        System.out.println("패턴 일치여부: " + "Hello Java!".matches(regex)); //true
        System.out.println("패턴 일치여부: " + "HelloJava!".matches(regex)); //false
    }
}
