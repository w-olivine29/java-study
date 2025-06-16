package ch21lang.section2string.section4method;

import java.util.Arrays;

public class StringUtilsMain1 {
    public static void main(String[] args) {
        int num = 1000;
        boolean bool = true;
        Object obj = new Object();
        Object nullObj = null;

        String str = "Hello, Java!";

        //valueOf()  다른타입 -> String 변환
        String numStr = String.valueOf(num);
        System.out.println("String.valueOf(num) = " + numStr);

        // 문자열 + 다른타입 -> 문자열화
        String numStr2 = num + "";
        System.out.println("numStr2 + \"\" = " + numStr2);

        String boolStr = String.valueOf(bool);
        System.out.println("String.valueOf(bool) -> " + boolStr);

        String objStr1 = String.valueOf(obj);
        String objStr2 = String.valueOf(nullObj);
        System.out.println("String.valueOf(obj1) -> " + objStr1);
        System.out.println("String.valueOf(obj2) -> " + objStr2);


        // toCharArray()
        char[] charArray = str.toCharArray();
        System.out.println(Arrays.toString(charArray)); // [H, e, l, l, o, ,,  , J, a, v, a, !]
    }
}
