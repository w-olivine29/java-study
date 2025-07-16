package ch02io.sub1basic.section3text.step1start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import static ch02io.sub1basic.section3text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV1 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";

        // 문자 - byte UTF-8 인코딩
        byte[] writeBytes = writeString.getBytes(UTF_8);
        System.out.println("writeString = " + writeString); //ABC
        System.out.println("writeBytes = " + Arrays.toString(writeBytes)); //[65, 66, 67]

        // 파일에 쓰기
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        fileOutputStream.write(writeBytes);
        fileOutputStream.close();


        // 파일에서 읽기
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME); //이곳에는 ABC 라는 문자가 저장돼있는게 아닌, 바이트배열이 저장돼있는것임

        byte[] readBytes = fileInputStream.readAllBytes();
        fileInputStream.close();

        // byte -> String UTF-8 디코딩
        String readString = new String(readBytes, UTF_8);

        System.out.println("readBytes = " + Arrays.toString(readBytes)); //[65, 66, 67]
        System.out.println("readString = " + readString); //ABC
        
    }
}

/* 
next step)
    텍스트 -> 인코딩 -> 바이트 -> 파일 -> 바이트 -> 디코딩 -> 텍스트
    이런 변환 과정을 대신 처리해주는 스트림이 있다.
 */