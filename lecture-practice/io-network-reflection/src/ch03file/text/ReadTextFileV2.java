package ch03file.text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadTextFileV2 {

    private static final String PATH = "io-network-reflection/temp/hello2.txt";

    // ch02io/sub1basic/section3text/step3bufferedreader/ReaderWriterMainV4.java 와 비교
    public static void main(String[] args) throws IOException {
        String writeString = "ABC\n가나다";
        System.out.println("==== Write String ====");
        System.out.println(writeString);

        Path path = Path.of(PATH);


        //파일에 쓰기 (없으면 파일 생성 후 쓰기)
        Path path1 = Files.writeString(path, writeString, UTF_8);

        System.out.println("==== Read String ====");

        // 파일에서 모든 문자를 라인 단위로 나눠서 한 번에 가져옴
        // 파일 사이즈가 크면 메모리 문제 발생 -> Files.lines(path) 를 사용하자
        List<String> lines = Files.readAllLines(path1, UTF_8);
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ":" + lines.get(i));
        }
        /*
        ==== Read String ====
        1:ABC
        2:가나다
        */

        
        // 한줄 씩 메모리에 올린다
        Stream<String> lineStream = Files.lines(path);
        lineStream.forEach(line -> System.out.println(line));

        lineStream.close();


    }
}
