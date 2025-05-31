package ch21lang.section2string.section4method;

// 문자열 정보 조회
public class StringInfoMethod {
    public static void main(String[] args) {
        String str = " Java ";
        System.out.println("\" Java \".length()  ->  " + str.length()); // 6 (공백문자도 길이에 포함된다.)
        System.out.println("\" Java \".isEmpty() -> " + str.isEmpty()); // return value.length == 0;  (문자열이 비어있는지)

        System.out.println("\" Java \".isBlank() -> " + str.isBlank());  // false (문자열이 비어있거나 공백인지)
        System.out.println("\"  \".isBlank() -> " + "  ".isBlank()); // true  (문자열이 비어있거나 공백인지)

        System.out.println("char0: " + str.charAt(0)); // " "
        System.out.println("char1: " + str.charAt(1)); // J
        System.out.println("char2: " + str.charAt(2)); // a
        System.out.println("char3: " + str.charAt(3)); // v
        System.out.println("char4: " + str.charAt(4)); // a
        System.out.println("char5: " + str.charAt(5)); // " "
    }
}
