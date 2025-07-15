package ch02io.sub1basic.section1start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

// 전체 읽기
public class StreamStartMain4_FullRead {
    public static void main(String[] args) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("io-network-reflection/temp/hello.dat");
        byte[] input = {65, 66, 67, 68};
        fileOutputStream.write(input);
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("io-network-reflection/temp/hello.dat");
        
        byte[] buffer = fileInputStream.readAllBytes(); //스트림이 끝날 때까지(파일의 끝에 도달할 때까지) 모든 데이터를 한 번에 읽어올 수 있음
        System.out.println(Arrays.toString(buffer)); //[65, 66, 67, 68]

        fileInputStream.close();
    }
}
/* 전체 읽기

readAllBytes()
 - 한 번의 호출로 모든 데이터 읽을 수 있음
 - 작은 파일이나 메모리에 모든 내용을 올려서 처리해야하는 경우에 적합
 - 메모리 사용량 제어 불가
 - 큰 파일의 경우 OutOfMemoryError 발생 가능
*/