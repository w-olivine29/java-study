package ch02io.sub1basic.section3text.step3bufferedreader;

import java.io.*;

import static ch02io.sub1basic.section3text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV4 {

    private static final int BUFFER_SIZE = 8192;

    public static void main(String[] args) throws IOException {
        String writeString = "ABC\n가나다";
        System.out.println("==== Write String ====");
        System.out.println(writeString);

        // 파일에 쓰기
        FileWriter writer = new FileWriter(FILE_NAME, UTF_8); // FileWriter -> OutputStreamWriter -> Writer
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        bufferedWriter.write(writeString); // 인코딩하지 않고 바로 넘길 수 있음
        bufferedWriter.close();


        // 파일에서 읽기
        FileReader reader = new FileReader(FILE_NAME, UTF_8); // FileReader -> InputStreamReader -> Reader
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder content = new StringBuilder();

        String line;

        while ((line = bufferedReader.readLine()) != null) { // 개행 단위로 읽어옴
            content.append(line).append("\n"); // 읽어올 때 라인이 제거되기 때문에 한줄 씩 구분
        }
        bufferedReader.close();

        System.out.println("==== Read String ====");
        System.out.println(content);
    }
}
/*

 */