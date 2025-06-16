package ch21lang.section2string.section4method;

import java.util.Arrays;

// 문자열 분할 및 조합
public class StringSplitJoinMain {
    public static void main(String[] args) {

        String str = "Java*Python*C*JavaScript*Php";

        // split()
        String[] splitArr = str.split("\\*"); // '*'는 정규식에서 특수문자여서 이스케이프처리 필요
        System.out.println(Arrays.toString(splitArr)); // [Java, Python, C, JavaScript, Php]

        //Join() -> Static member
        // 배열, 개별 문자열들을 인수로 넣을 수 있음
        // 같은 타입만 넣을 수 있다
        System.out.println("str.join(\"-\", splitArr) -> "
                + String.join("-", splitArr));//Java-Python-C-JavaScript-Php

        System.out.println("str.join(\"-\", splitArr) -> "
                + String.join("-", "a", "b", "c"));//a-b-c

/*        System.out.println("str.join(\"-\", splitArr) -> "
                + String.join("-", "a", "b", "c", splitArr));*/
    }
}
