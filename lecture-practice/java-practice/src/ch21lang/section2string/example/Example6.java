package ch21lang.section2string.example;

// 공백 제거하기
public class Example6 {
    public static void main(String[] args) {

        String str = "   java kotlin python swift go  ";

        //양쪽 공백제거
        System.out.println(str.strip());
        System.out.println(str.trim());

        // 앞 공백 제거
        System.out.println(str.stripLeading());

        // 뒤 공백 제거
        System.out.println(str.stripTrailing());

        //모든 공백제거
        System.out.println(str.replace(" ", ""));


    }
}
