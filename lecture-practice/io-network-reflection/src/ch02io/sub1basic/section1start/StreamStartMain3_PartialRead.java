package ch02io.sub1basic.section1start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

// 부분으로 나누어 읽기
public class StreamStartMain3_PartialRead {
    public static void main(String[] args) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("io-network-reflection/temp/hello.dat");
        byte[] input = {65, 66, 67, 68};
        fileOutputStream.write(input);
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("io-network-reflection/temp/hello.dat");
        
        byte[] buffer = new byte[10];

        // int read(byte[] b, int offset, int length)
        // byte[]:데이터가 읽혀지는 버퍼
        // offset: 데이터가 기록되는 byte[]의 인덱스 시작 위치
        // length: 읽어올 byte의 최대길이
        // 인수 생략 시 넘긴 buffer 배열의 0, 배열의길이를 사용
        int readCount = fileInputStream.read(buffer, 1, 9);
        System.out.println("readCount = " + readCount); //readCount = 4 (4바이트만 읽었다)
        System.out.println(Arrays.toString(buffer)); //[0, 65, 66, 67, 68, 0, 0, 0, 0, 0]

        fileInputStream.close();
    }
}
/* 부분으로 나누어 읽기

read(byte[], offset, length)
 - 스트림의 내용을 부분적으로 읽거나, 읽은 내용을 처리하면서 계속 읽어야할 경우에 적합
 - 메모리 사용량 제어 가능 (한 번에 사용하는 메모리 용량 제어)
*/