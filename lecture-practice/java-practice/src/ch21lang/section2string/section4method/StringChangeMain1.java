package ch21lang.section2string.section4method;


// 문자열 조작 및 변환1
public class StringChangeMain1 {
    public static void main(String[] args) {
        String str = "Hello Java, Welcome to Java world";

        // 추출
        System.out.println("인덱스 6부터의 부분 문자열 추출: " + str.substring(6));
        System.out.println("인덱스 6부터의 9까지의 부분 문자열 추출: " + str.substring(6, 10)); //끝 인덱스는 제외
        System.out.println("인덱스 6부터의 9까지의 부분 문자열 추출: " + str.substring(6, 10)); //끝 인덱스는 제외

        //결합
        System.out.println("문자열 결합: " + (str.concat("!!!")));
        System.out.println("문자열 결합: " + (str + "!!!"));

        // 대체
        System.out.println("Java -> Computer Science 로 대체: "
                + str.replace("Java", "Computer Science"));

        System.out.println("첫 번째 Java 만 Computer Science 로 대체: "
                + str.replaceFirst("Java", "Computer Science"));
    }
}
