package ch21lang.section2string.section1basic;

public class StringBasicMain {
    public static void main(String[] args) {

        // String 생성방법
        String str1 = new String("java"); //String은 클래스 -> 객체 (new 사용해야함)

        //문자열 리터럴 방식 (XX부분 참조)
        String str2 = "java"; //자바에서 new String("java") 로 변경해줌 (그러나 직접 new String("") 하는 것과 방식다름)

        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
    }
}
