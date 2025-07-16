package ch02io.sub1basic.section3text.step2readerwriter;

import java.io.*;

import static ch02io.sub1basic.section3text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV2 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        System.out.println("writeString = " + writeString);

        // 파일에 쓰기
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, UTF_8);

        writer.write(writeString); // 인코딩하지 않고 바로 넘길 수 있음
        writer.close();


        // 파일에서 읽기
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME); //이곳에는 ABC 라는 문자가 저장돼있는게 아닌, 바이트배열이 저장돼있는것임
        InputStreamReader reader = new InputStreamReader(fileInputStream, UTF_8);

        StringBuilder content = new StringBuilder();
        int ch;
        while ((ch = reader.read()) != -1) { // 자바의 char는 -1을 표현할 수 없어서 대신 int 반환
            content.append((char) ch);
        }
        reader.close();

        System.out.println("read String = " + content);

    }
}
