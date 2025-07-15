package ch01encoding.section2encoding;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;

public class EncodingMain2 {

    private static final Charset EUC_KR = Charset.forName("EUC_KR");
    private static final Charset MS_949 = Charset.forName("MS_949");

    public static void main(String[] args) {
        System.out.println("===== 영문 ASCII 인코딩 =====");

        // 웬만한 문자집합들은 ASCII를 기본으로 깔고 감
        test("A", US_ASCII, US_ASCII); //A -> [65] 1byte -> A
        test("A", US_ASCII, ISO_8859_1); //A -> [65] 1byte -> A  [ASCII 확장(ALTIN-1)]
        test("A", US_ASCII, EUC_KR); //A -> [65] 1byte -> A  [ASCII 포함]
        test("A", US_ASCII, MS_949); //A -> [65] 1byte -> A  [ASCII 포함]
        test("A", US_ASCII, UTF_8); //A -> [65] 1byte -> A  [ASCII 포함]

        test("A", US_ASCII, UTF_16BE); //A -> [65] 1byte -> �  디코딩 실패 - (ASCII 와 호환x)

        System.out.println("===== 한글 인코딩 - 기본 =====");
        test("가", US_ASCII, US_ASCII); // 실패) 가 -> [63] 1byte -> ?  [아스키코드의 63은 '?']
        test("가", ISO_8859_1, ISO_8859_1); // 실패) 가 -> [63] 1byte -> ?  [아스키코드의 63은 '?']
        test("가", EUC_KR, EUC_KR); // 성공) 가 -> [-80, -95] 2byte -> 가
        test("가", MS_949, MS_949); // 성공) 가 -> [-80, -95] 2byte -> 가
        test("가", UTF_8, UTF_8); // 성공) 가 -> [-22, -80, -128] 3byte -> 가
        test("가", UTF_16BE, UTF_16BE); // 성공) 가 -> [-84, 0] 2byte -> 가

        System.out.println("===== 한글 인코딩 - 복잡한 문자 =====");
        test("뷁", EUC_KR, EUC_KR); // 실패) 뷁 -> [63] 1byte -> ?
        test("뷁", MS_949, MS_949); // 성공) 뷁 -> [-108, -18] 2byte -> 뷁   (MS_949 는 EUC_KR을 확장 -> 모든 한글 표현 가능)
        test("뷁", UTF_8, UTF_8); // 성공) 뷁 -> [-21, -73, -127] 3byte -> 뷁
        test("뷁", UTF_16BE, UTF_16BE); // 성공) 뷁 -> [-67, -63] 2byte -> 뷁


        System.out.println("===== 한글 인코딩 - 디코딩이 다른 경우 =====");
        test("가", EUC_KR, MS_949); //성공) 가 -> [-80, -95] 2byte -> 가  (MS_949 는 EUC_KR을 확장)

        test("가", MS_949, EUC_KR); //성공) 가 -> [-80, -95] 2byte -> 가  (MS_949 는 EUC_KR을 확장)
        test("뷁", MS_949, EUC_KR); //실패) 가 -> [-108, -18] 2byte -> ��  ("뷁"은 EUC_KT이 표현 불가능한 문자)

        test("가", EUC_KR, UTF_8); //실패) 가 -> [-80, -95] 2byte -> ��  (인코딩 가능, 디코딩 불가)

        test("가", MS_949, UTF_8); //실패) 가 -> [-80, -95] 2byte -> ��  (인코딩 가능, 디코딩 불가)
        test("가", UTF_8, MS_949); //실패) 가 -> [-22, -80, -128] 3byte -> 媛�  (인코딩 가능, 디코딩 불가)

        System.out.println("===== 영문 인코딩 - 디코딩이 다른 경우 =====");
        // 영문 인코딩은 UTF-16 을 제외하고 모두 호환
        test("A", EUC_KR, UTF_8); // A -> [65] 1byte -> A
        test("A", MS_949, UTF_8); //A -> [65] 1byte -> A  [ASCII 포함]
        test("A", UTF_8, MS_949); //A -> [65] 1byte -> A  [ASCII 포함]
        test("A", UTF_8, UTF_16BE); //A -> [65] 1byte -> �  디코딩 실패 - (ASCII 와 호환x)
    }

    private static void test(String text, Charset encodingCharset, Charset decodingCharset) {
        byte[] encoded = text.getBytes(encodingCharset);
        String decoded = new String(encoded, decodingCharset);


        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte -> [%s] 디코딩 -> %s\n",
                text,
                encodingCharset,
                Arrays.toString(encoded),
                encoded.length,
                decodingCharset,
                decoded
        );

    }
}

/*
문자 인코딩)
    문자를 컴퓨터가 이해할 수 있는 숫자(Byte)로 변경하는것
*/