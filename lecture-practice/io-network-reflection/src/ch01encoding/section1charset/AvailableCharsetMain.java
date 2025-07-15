package ch01encoding.section1charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.SortedMap;

public class AvailableCharsetMain {
    public static void main(String[] args) {

        // 이용 가능한 모든 Charset 자바 + OS
        SortedMap<String, Charset> charset = Charset.availableCharsets();
        for (String charsetName : charset.keySet()) {
            System.out.println("charsetName = " + charsetName);
        }

        System.out.println("===============");
        // 문자로 조회(대소문자 구분x)
        Charset charset1 = Charset.forName("MS949"); //ms949 라고 해도 된다.
        System.out.println("charset1 = " + charset1); //charset1 = x-windows-949

        // 별칭으로 조회
        for (String alias : charset1.aliases()) {
            System.out.println("alias = " + alias);
            //alias = ms949
            //alias = windows949
            //alias = windows-949
            //alias = ms_949
        }

        // UTF - 8 문자로 조회
        Charset charset2 = Charset.forName("UTF-8"); //StandardCharsets.UTF_8 can be used instead
        System.out.println("charset2 = " + charset2);

        // 자주쓰는 문자셋은 상수로 정의돼있음
        Charset charset3 = StandardCharsets.UTF_8;
        System.out.println("charset3 = " + charset3);
        
        // 시스템의 기본 Charset 조회
        Charset defaultCharset = Charset.defaultCharset();
        System.out.println("defaultCharset = " + defaultCharset);
    }
}
