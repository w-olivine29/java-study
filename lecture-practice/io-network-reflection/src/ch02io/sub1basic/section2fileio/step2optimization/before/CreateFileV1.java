package ch02io.sub1basic.section2fileio.step2optimization.before;

import java.io.FileOutputStream;
import java.io.IOException;

import static ch02io.sub1basic.section2fileio.step2optimization.BufferedConst.*;

public class CreateFileV1 {
    public static void main(String[] args) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);

        // 파일 생성 소요시간
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < FILE_SIZE; i++) { //파일에 계속 1바이트를 사용 ->  10MB 크기의 파일 만들기
            fileOutputStream.write(1);
        }
        fileOutputStream.close();
        
        long endTime = System.currentTimeMillis();

        System.out.println("File created:" + FILE_NAME);
        System.out.println("File size: " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms"); //38598ms
    }
}
