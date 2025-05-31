package ch21lang.section2string.section4method;

// 문자열 검색
public class StringSearchMain {
    public static void main(String[] args) {
        String str = "Hello Java, Hello Computer Science";
        System.out.println("str = " + str);


        System.out.println("문자열에 \"welcome\" 이 포함돼있는지 -> " + str.contains("welcome"));


        // 인덱스 구하기 (없으면 -1반환)

        // indexOf()
        System.out.println("\"welcome\"의 첫번 째 인덱스 -> " + str.indexOf("welcome")); //-1
        System.out.println("\"Hello\"의 첫번 째 인덱스 -> " + str.indexOf("Hello")); //0
        System.out.println("\"Java\"의 첫번 째 인덱스 -> " + str.indexOf("Java")); //6

        System.out.println("인덱스 10부터 \"Hello\"의 첫번 째 인덱스 -> " + str.indexOf("Hello", 10)); //12

        System.out.println("인덱스 4부터 9사이 \"Hello\"의 첫번 째 인덱스 -> "
                + ("Hello hi Hello hi hi Hello".indexOf("Hello", 4, 9))); //-1  (o hi )

        System.out.println("인덱스 8부터 13사이 \"Hello\"의 첫번 째 인덱스 -> "
                + ("Hello hi Hello hi hi Hello".indexOf("Hello", 8, 13))); //-1 ( Hell)

        System.out.println("인덱스 8부터 14사이 \"Hello\"의 첫번 째 인덱스 -> "
                + ("Hello hi Hello hi hi Hello".indexOf("Hello", 4, 14))); //9 ( Hello)

        //"Hello Java, Hello Computer Science";
        //"0123456789012345678901234567890123"
        // 0         1         2         3



        // lastIndexOf()
        System.out.println("\"Hello\"의 마지막 인덱스 -> " + str.lastIndexOf("Hello")); //12

        // lastIndexOf(문자열, 탐색시작위치) -> fromIndex 부터 왼쪽으로 문자열을 찾아 가장 마지막 위치 반환
        // 쉽게 생각하면, fromIndex 로 자른 상태의 문자열에서 마지막으로 나타나는 인덱스
        System.out.println("str.lastIndexOf(\"Hello\",5) -> " + str.lastIndexOf("Hello",5)); // 0
        System.out.println("str.lastIndexOf(\"Hello\",3) -> " + str.lastIndexOf("Hello",3)); // 0

        System.out.println("str.lastIndexOf(\"Hello\",17) -> " + str.lastIndexOf("Hello",17)); // 12
        System.out.println("str.lastIndexOf(\"Hello\",13) -> " + str.lastIndexOf("Hello",13)); // 12

        //"Hello Java, Hello Computer Science";
        //"0123456789012345678901234567890123"
        // 0         1         2         3
    }
}
