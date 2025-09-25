package ch04stream.task;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.function.IntFunction;
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
            settingFile(filePath, "Donkey7 9Sweet Potato6 \nLemon30 olive 29coffee 치킨 \n\n Water Cabbage");

            // 모든 라인 대문자 변환 출력 (한 줄 단위로 문자열 통일 처리)
            printLines(getTextLineStream(filePath), String::toUpperCase);


            // 한 줄 단위 -> 문자단위로 처리 (문자마다 원하는 변환 가능)
            printLines(getTextLineStream(filePath), mapChars(codePoint -> {

                if (Character.isDigit(codePoint)) {
                    return '*';
                }
                if (Character.isLowerCase(codePoint)) {
                    return (char) Character.toUpperCase(codePoint);
                }
                return (char) Character.toLowerCase(codePoint);
            }));

        } catch (IOException e) {
            System.out.println("IOException 발생: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("예기치 못한 예외 발생: " + e.getMessage());
        }

    }


    public static void printLines(Stream<String> readLines, Function<String, String> lineTransformer) {

        readLines.forEach(line -> {
            System.out.println(line.transform(lineTransformer));
        });
    }


    // 문자 단위 처리 가능한 함수
    public static Function<String, String> mapChars(IntFunction<Character> charMapper) {
        return line -> {
            StringBuilder sb = new StringBuilder();

            line.chars()
                    .mapToObj(charMapper) // 문자에 대한 처리를 동적으로 받기
                    .forEach(sb::append);

            return sb.toString();
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
