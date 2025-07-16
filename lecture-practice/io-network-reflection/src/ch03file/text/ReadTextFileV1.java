package ch03file.text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadTextFileV1 {

    private static final String PATH = "io-network-reflection/temp/hello2.txt";

    // ch02io/sub1basic/section3text/step3bufferedreader/ReaderWriterMainV4.java 와 비교
    public static void main(String[] args) throws IOException {
        String writeString = "ABC\n가나다";
        System.out.println("==== Write String ====");
        System.out.println(writeString);

        Path path = Path.of(PATH);
        

        //파일에 쓰기 (없으면 파일 생성 후 쓰기)
        Path path1 = Files.writeString(path, writeString, UTF_8);

        // 파일에서 모든 문자 읽기
        String readString = Files.readString(path, UTF_8);


        System.out.println("==== Read String ====");
        System.out.println(readString);
    }
}
