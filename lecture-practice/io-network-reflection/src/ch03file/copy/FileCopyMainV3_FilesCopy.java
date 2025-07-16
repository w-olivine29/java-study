package ch03file.copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileCopyMainV3_FilesCopy {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        Path source = Path.of("io-network-reflection/temp/copy.dat");
        Path target = Path.of("io-network-reflection/temp/copy_new.dat");


        // Files.copy() 는 자바에 파일 데이터를 불러오지 않음
        // 운영체제의 파일 복사 기능 사용
        // source 파일 -> target 파일
        // 별도의 처리는 할 수 없어서, 파일을 복사할 때만 유용
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms"); //86ms
    }
}
