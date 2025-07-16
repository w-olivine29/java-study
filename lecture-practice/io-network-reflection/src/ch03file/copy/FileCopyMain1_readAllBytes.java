package ch03file.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyMain1_readAllBytes {
    public static void main(String[] args) throws IOException {

        long startTime = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("io-network-reflection/temp/copy.dat");
        FileOutputStream fos = new FileOutputStream("io-network-reflection/temp/copy_new.dat");

        // 대상 파일의 내용을 읽어와서, 다른 파일에 복사
        byte[] bytes = fis.readAllBytes();
        fos.write(bytes);

        fis.close();
        fos.close();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms"); //452ms
    }
}
/*
파일 (copy.dat) -> 자바(Byte) -> 파일(copy_new.dat)
자바가 파일의 데이터를 자바 프로세스가 사용하는 메모리에 불러옴
메모리에 있는 데이터를 파일에 전달
*/