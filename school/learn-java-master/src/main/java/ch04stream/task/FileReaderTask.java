package ch04stream.task;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.stream.Stream;

/* 파일 Stream 처리

- 임의의 txt 파일을 읽어, 모든 라인 대문자로 바꾸어 출력
- Functional Interface, Stream 사용여부
*/

// 41기 유도경
public class FileReaderTask {

    public static void main(String[] args) {

        String fileName = "task1.txt";

        try {

            Path filePath = Path.of(fileName);
            settingFile(filePath, "Donkey Sweet Potato \nLemon olive coffee 치킨 \n\n Water Cabbage");

            printCharsFromLines(getTextLineStream(filePath), upperCasePrinter());

        } catch (IOException e) {
            System.out.println("IOException 발생: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("예기치 못한 예외 발생: " + e.getMessage());
        }

    }


    public static void printCharsFromLines(Stream<String> readLines, Consumer<Integer> consumer) {

        readLines.forEach(line -> {
            printChars(line, consumer);
            System.out.println();
        });

    }


    public static void printChars(String text, Consumer<Integer> consumer) {

        // Arrays.stream() 은 char[] 받지 않음
        // chars()로 해당 문자들의 code point 로 이뤄진 IntStream
        text.chars()
                .forEach(consumer::accept);
    }


    public static Consumer<Integer> upperCasePrinter() {

        // code point ->  char 타입 캐스팅 -> 출력
        return charNum -> {

            if (Character.isLowerCase(charNum)) {
                System.out.print((char) Character.toUpperCase(charNum));

            } else {
                // 소문자가 아니라면 그대로 출력
                System.out.print((char) charNum.intValue());
            }
        };
    }


    private static Stream<String> getTextLineStream(Path path) throws IOException {
        return Files.lines(path);
    }


    private static void settingFile(Path path, String text) throws IOException {
        // 해당 경로에 파일이 없다면 파일생성 + 문자 생성
        Files.writeString(path, text, StandardCharsets.UTF_8);

        //StandardOpenOption 기본옵션 셋) CREATE, TRUNCATE_EXISTING, WRITE
        // TRUNCATE_EXISTING: 파일 존재 시 기존 내용 덮어씌우기
    }
}
