package ch02io.sub1basic.section3text.step2readerwriter;

import java.io.*;

import static ch02io.sub1basic.section3text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV3 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        System.out.println("writeString = " + writeString);

        // 파일에 쓰기
        FileWriter writer = new FileWriter(FILE_NAME, UTF_8); // FileWriter -> OutputStreamWriter -> Writer

        writer.write(writeString); // 인코딩하지 않고 바로 넘길 수 있음
        writer.close();


        // 파일에서 읽기
        FileReader reader = new FileReader(FILE_NAME, UTF_8); // FileReader -> InputStreamReader -> Reader

        StringBuilder content = new StringBuilder();
        int ch;
        while ((ch = reader.read()) != -1) { // 자바의 char는 -1을 표현할 수 없어서 대신 int 반환
            content.append((char) ch);
        }
        reader.close();

        System.out.println("read String = " + content);
    }
}
/*
FileWriter, FileReader 는 내부에서 스스로 FileXxxStream 을 생성해서 사용 (모든 데이터는 결국 byte 단위로 저장된다는 사실)
 - OutputStreamWriter, InputStreamReader 를 상속하고, 별 다른 추가 기능 없음
 - 차이점은 내부에서 OutputStreamWriter, InputStreamReader를 생성하고, FileXxxStream 을 생성해준다.
 
 FileWriter write()
    - 내부에서 인코딩 셋 사용 -> byte 변경 -> FileOutputStream 사용 -> 파일에 저장
    
 FileReader read()
    - 내부에서는 FileInputStream 사용 -> 데이터를 byte 단위로 읽어들임 -> 문자집합 사용 -> byte[] 을 char 디코딩
*/