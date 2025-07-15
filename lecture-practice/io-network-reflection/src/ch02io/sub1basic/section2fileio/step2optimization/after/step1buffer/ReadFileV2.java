package ch02io.sub1basic.section2fileio.step2optimization.after.step1buffer;

import java.io.FileInputStream;
import java.io.IOException;

import static ch02io.sub1basic.section2fileio.step2optimization.BufferedConst.*;

public class ReadFileV2 {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);

        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        int size;

        byte[] buffer = new byte[BUFFER_SIZE];
        while ((size = fileInputStream.read(buffer, 0, buffer.length)) != -1) { // 몇 바이트 읽어왔는지에 대한 사이즈 반환
            fileSize += size;
        }
        fileInputStream.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File name:" + FILE_NAME);
        System.out.println("File size: " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms"); //4ms

    }
}
/*

 */