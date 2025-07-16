package ch03file.copy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateCopyFile {

    private static final int FILE_SIZE = 200 * 1024 * 1024;//200MB

    public static void main(String[] args) throws IOException {

        String fileName = "io-network-reflection/temp/copy.dat";

        long startTime = System.currentTimeMillis();
        FileOutputStream fileOutputStream = getFileOutputStream(fileName);
        byte[] buffer = new byte[FILE_SIZE];
        fileOutputStream.write(buffer);
        fileOutputStream.close();

        long endTime = System.currentTimeMillis();

        System.out.println("File created: " + fileName);
        System.out.println("File size:" + (FILE_SIZE / 1024 / 1024) + "MB");
        System.out.println("File taken:" + (endTime - startTime) + "ms"); //309ms

    }

    private static FileOutputStream getFileOutputStream(String fileName) throws FileNotFoundException {
        return new FileOutputStream(fileName);
    }
}
