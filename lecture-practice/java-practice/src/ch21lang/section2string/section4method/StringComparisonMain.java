package ch21lang.section2string.section4method;

// 문자열 비교
public class StringComparisonMain {
    public static void main(String[] args) {
        String str1 = "Hello, Java-"; //대문자 있음
        String str2 = "hello, java-"; //모두 소문자
        String str3 = "Hello, CS-";

        System.out.println("\n=== equals ==================");

        System.out.println("str1 equals str2 -> " + str1.equals(str2));
        System.out.println("str1 equalsIgnoreCase str2 -> " + str1.equalsIgnoreCase(str2));


        System.out.println("\n=== compareTo ==================");
        // 사전적 비교
        // 앞에서부터 차례대로 비교, 처음으로 다른 문자가 나타나면 유니코드 값 차이로 비교 종료
        System.out.println("'b' compareTo 'a' -> " + "b".compareTo("a")); //1 (b는 a보다 1 뒤)
        System.out.println("'a' compareTo 'b' -> " + "a".compareTo("b")); //-1 (a는 b보다 1 앞)

        System.out.println("'c' compareTo 'a' -> " + "c".compareTo("a")); //2
        System.out.println("'a' compareTo 'c' -> " + "a".compareTo("c")); //-2

        System.out.println("str1 compare to str2 -> " + str1.compareTo(str2)); //-32
        System.out.println("str1 compare to str3 -> " + str1.compareTo(str3)); //7


        System.out.println("\n=== compareToIgnoreCase ==================");
        System.out.println("str1 compareToIgnoreCase str2 -> " + str1.compareToIgnoreCase(str2)); //0
        System.out.println("str1 compareToIgnoreCase str3 -> " + str1.compareToIgnoreCase(str3)); //7

        //startsWith
        System.out.println("\n=== startsWith ==================");
        System.out.println("str1 startsWith str2 -> " + str1.startsWith("Hello")); //true
        System.out.println("str1 startsWith str3 -> " + str1.startsWith("hello")); //false

        //endsWith
        System.out.println("\n=== endsWith ==================");
        System.out.println("str1 endsWith str2 -> " + str1.endsWith("Java-")); //true
        System.out.println("str1 endsWith str3 -> " + str1.endsWith("hello")); //false

    }
}
