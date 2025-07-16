package ch02io.sub1basic.section4etc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;


public class PrintStreamEtcMain {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("io-network-reflection/temp/print.txt");
        PrintStream printStream = new PrintStream(fileOutputStream);

        // 이제껏 사용했던 것처럼 콘솔에 출력되는 것이 아닌, 파일이나 다른 스트림에 문자출력
        printStream.println("wow...");
        printStream.println(10);
        printStream.println(true);
        printStream.printf("hello %s","stream");

        printStream.close();
    }
}
