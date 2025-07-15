package ch01encoding.section2encoding;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;

public class EncodingMain1 {

    private static final Charset EUC_KR = Charset.forName("EUC_KR");
    private static final Charset MS_949 = Charset.forName("MS_949");

    public static void main(String[] args) {
        System.out.println("=== ASCII 영문 처리 ===");
        encoding("A", US_ASCII); //[65] 1byte
        encoding("A", ISO_8859_1); //[65] 1byte  (아스키와 호환)
        encoding("A", EUC_KR); //[65] 1byte  (아스키와 호환)
        encoding("A", UTF_8); //[65] 1byte  (아스키와 호환)

        encoding("A", UTF_16); //[-2, -1, 0, 65] 4byte
        encoding("A", UTF_16BE); //[0, 65] 2byte

        System.out.println("=== 한글 지원 ===");
        encoding("가", EUC_KR); //[-80, -95] 2byte
        encoding("가", MS_949); //[-80, -95] 2byte
        encoding("가", UTF_8); //[-22, -80, -128] 3byte
        encoding("가", UTF_16BE); //[-84, 0] 2byte


    }

    private static void encoding(String text, Charset charset) {
        
        // 모든 문자를 byte 로 바꿀 떄는 항상 인코딩표가 있어야함
        byte[] bytes = text.getBytes(charset); // 문자집합 지정하지 않으면 현재 시스템에서 사용하는 기본 문자 집합 사용
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte\n",
                text, charset,
                Arrays.toString(bytes),
                bytes.length);
    }
}

/*
문자 인코딩)
    문자를 컴퓨터가 이해할 수 있는 숫자(Byte)로 변경하는것
*/