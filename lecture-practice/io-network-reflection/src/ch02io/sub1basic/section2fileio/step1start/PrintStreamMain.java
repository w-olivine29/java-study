package ch02io.sub1basic.section2fileio.step1start;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class PrintStreamMain {
    public static void main(String[] args) throws IOException {

        // 해당 stream 은 자바 시작 시 자동생성
        PrintStream printStream = System.out; // 상속구조) PrintStream -> FilterOutputStream -> OutputStream

        byte[] bytes = "printStream!\n".getBytes(StandardCharsets.UTF_8);
        printStream.write(bytes); //부모 기능
        printStream.println("printStream!"); //부가기능
    }
}
