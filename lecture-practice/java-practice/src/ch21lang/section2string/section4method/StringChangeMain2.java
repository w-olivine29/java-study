package ch21lang.section2string.section4method;

//문자열 조작 및 변환2
public class StringChangeMain2 {
    public static void main(String[] args) {
        String strWithSpaces = "    Java Programming      ";

        // 대소문자 변환
        System.out.println("전부 소문자로 변환: " + strWithSpaces.toLowerCase());
        System.out.println("전부 대문자로 변환: " + strWithSpaces.toUpperCase());

        // 공백제거(trim) - Whitespace만 제거 가능
        System.out.println("양쪽 공백 제거(trim): " + "*" + strWithSpaces.trim() + "*"); // 문자열 앞뒤 공백

        // 공백제거 (strip) - Whitespace, 유니코드 공백 포함 제거
        System.out.println("양쪽 공백 제거(strip): " + "*" + strWithSpaces.strip() + "*"); // *Java Programming*
        System.out.println("앞 공백 제거(): " + "*" + strWithSpaces.stripLeading() + "*"); // *Java Programming      *
        System.out.println("뒤 공백 제거(): " + "*" + strWithSpaces.stripTrailing() + "*"); //*    Java Programming*

    }
}
