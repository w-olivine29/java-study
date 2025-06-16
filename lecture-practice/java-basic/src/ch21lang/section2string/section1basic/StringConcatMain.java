package ch21lang.section2string.section1basic;

public class StringConcatMain {
    public static void main(String[] args) {
        
        // a,b에는 참조값이 들어있음
        String a = "git";
        String b = "hub";

        // 자바에서 문자열을 더할 땐 String 클래스가 제공하는 concat() 사용
        String result1 = a.concat(b);
        System.out.println("result1 = " + result1);

        String result2 = a + b; // 참조값이 들어있지만 + 연산이 된다
        System.out.println("result2 = " + result2);

    }
}
