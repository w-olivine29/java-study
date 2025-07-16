package ch02io.sub1basic.section2fileio.step2optimization.after.step3bulk;

import java.io.FileInputStream;
import java.io.IOException;

import static ch02io.sub1basic.section2fileio.step2optimization.BufferedConst.FILE_NAME;
import static ch02io.sub1basic.section2fileio.step2optimization.BufferedConst.FILE_SIZE;

public class ReadFileV4 {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);

        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        int data;

        byte[] bytes = fileInputStream.readAllBytes();
        fileInputStream.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File name:" + FILE_NAME);
        System.out.println("File size: " + bytes.length / 1024 / 1024 + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms"); //9ms

        /* readAllBytes() 자바 구현에 따라 다르나,
          보통 4KB, 8Kb, 16KB 단위로 데이터를 읽어들인다. */

    }
}
/*

*/