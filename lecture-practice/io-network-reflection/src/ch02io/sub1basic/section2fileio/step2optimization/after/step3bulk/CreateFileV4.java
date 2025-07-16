package ch02io.sub1basic.section2fileio.step2optimization.after.step3bulk;

import java.io.FileOutputStream;
import java.io.IOException;

import static ch02io.sub1basic.section2fileio.step2optimization.BufferedConst.FILE_NAME;
import static ch02io.sub1basic.section2fileio.step2optimization.BufferedConst.FILE_SIZE;

public class CreateFileV4 {
    public static void main(String[] args) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);

        // 파일 생성 소요시간
        long startTime = System.currentTimeMillis();

        byte[] buffer = new byte[FILE_SIZE];
        for (int i = 0; i < FILE_SIZE; i++) { //파일에 계속 1바이트를 사용 ->  10MB 크기의 파일 만들기
            buffer[i] = 1;
        }
        fileOutputStream.write(buffer);

        fileOutputStream.close();
        long endTime = System.currentTimeMillis();

        System.out.println("File created:" + FILE_NAME);
        System.out.println("File size: " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms"); //13ms

/*       디스크나 파일 시스템에서 데이터를 읽고 쓰는 기본 단위가 보통 4KB, 8KB 이기때문에,
         buffer 사이즈를 엄청 크게 만들어서 사용해도 무작정 빨라지는 것은 아님*/
    }
}
