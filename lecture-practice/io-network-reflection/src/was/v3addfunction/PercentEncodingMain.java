package was.v3addfunction;

import java.net.URLDecoder;
import java.net.URLEncoder;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PercentEncodingMain {
    public static void main(String[] args) {

        String ga = URLEncoder.encode("ga", UTF_8);
        System.out.println("ga = " + ga); //ga = ga
        
        // 아스키문자가 아닌 것은 인코딩
        String encode = URLEncoder.encode("가", UTF_8);
        System.out.println("가 = " + encode); //가 = %EA%B0%80

        String decode = URLDecoder.decode(encode, UTF_8);
        System.out.println("decode = " + decode); //decode = 가

    }
}
