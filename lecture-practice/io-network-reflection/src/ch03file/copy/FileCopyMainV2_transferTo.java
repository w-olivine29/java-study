package ch03file.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyMainV2_transferTo {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("io-network-reflection/temp/copy.dat");
        FileOutputStream fos = new FileOutputStream("io-network-reflection/temp/copy_new.dat");

        // 성능 최적화가 돼있어서, 예제1보다 빠른 편
        // copy.dat -> 자바(Byte)-> copy_new.dat
        fis.transferTo(fos);

        fis.close();
        fos.close();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms"); //172ms
    }
}
