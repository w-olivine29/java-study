package mission.week2;


/* 3. 파일복사 프로그램 만들기

- Buffered 스트림 사용 여부
- 파일 복사가 오류 없이 되는지
*/


import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;


// 41기 유도경
public class FileCopyManager {

    static final int BUFFER_SIZE = 8192; //8KB


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FileCopyManager manager = new FileCopyManager();

        System.out.print("복사할 원본 파일을 입력해주세요. (경로/파일이름.확장자): ");
        String sourceFilePath = scanner.nextLine();

        System.out.print("복사파일의 이름을 입력해주세요. (경로/파일이름.확장자): ");
        String copyFilePath = scanner.nextLine();


        try (scanner) {
            manager.copyFile(sourceFilePath, copyFilePath, scanner);
        } catch (FileCopyException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O관련 오류발생" + e.getMessage());
        } catch (Exception e){
            System.out.println("그 외 오류 발생" + e.getMessage());
            e.printStackTrace();
        }finally {
            System.out.println("파일 복사를 종료합니다.");
        }


    }

    public void copyFile(String sourceFilePath, String copyFilePath, Scanner scanner) throws IOException {

        validatePaths(Path.of(sourceFilePath), Path.of(copyFilePath), scanner);

        // 자원 자동 닫기만 하고 예외는 밖에서 잡는걸로
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(sourceFilePath));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(copyFilePath));
        ) {

            byte[] buffer = new byte[BUFFER_SIZE];

            int readSize;  // 몇 바이트 읽어왔는지에 대한 사이즈 반환 -> -1 이면 EOF
            while ((readSize = inputStream.read(buffer)) != -1) { // 지정한 버퍼에 데이터를 받아오고 그대로 write
                outputStream.write(buffer);
            }

            // try-with-resources 구문 덕분에 별도의 close() 구문 생략가능
            // outputStream 이 close 될 때, 내부적으로 자동 flush

            System.out.println("파일 복사가 완료되었습니다.");
        }

    }

    private void validatePaths(Path sourceFilePath, Path copyFilePath, Scanner scanner) {

        if (!Files.exists(sourceFilePath)) {
            throw new InvalidPathException(sourceFilePath.toString(), "원본 파일이 존재하지 않습니다");
        }
        if (!Files.isReadable(sourceFilePath)) {
            throw new FileCopyException("원본 파일을 읽을 수 없습니다.", sourceFilePath);
        }
        if (Files.exists(copyFilePath)) {
            handleFileConflict(copyFilePath, scanner);
        }
        if (Files.exists(copyFilePath) && Files.isWritable(copyFilePath)) {
            throw new FileCopyException("대상 파일에 쓸 수 없습니다.", copyFilePath);
        }
    }

    private void handleFileConflict(Path targetPath, Scanner scanner) {

        System.out.printf("이미 존재하는 파일입니다. (%s)\n", targetPath);
        System.out.println("덮어쓰기(Y) / 취소 (아무 키)");

        if (!"Y".equalsIgnoreCase(scanner.nextLine())) {
            throw new FileCopyException("파일 복사를 취소했습니다.");
        }

    }

}

class FileCopyException extends RuntimeException {

    public FileCopyException(String message) {
        super(message);
    }

    public FileCopyException(String message, Path... paths) {
        super(String.format("%s: %s", message, Arrays.toString(paths)));
    }
}