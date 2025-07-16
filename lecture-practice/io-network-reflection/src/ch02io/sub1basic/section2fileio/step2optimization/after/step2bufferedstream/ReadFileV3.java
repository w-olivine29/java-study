package ch02io.sub1basic.section2fileio.step2optimization.after.step2bufferedstream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import static ch02io.sub1basic.section2fileio.step2optimization.BufferedConst.FILE_NAME;
import static ch02io.sub1basic.section2fileio.step2optimization.BufferedConst.FILE_SIZE;

public class ReadFileV3 {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);


        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        int data;

        while ((data = bufferedInputStream.read()) != -1){
            // 1. bufferedInputStream.read() -> 먼저 버퍼를 확인 (버퍼에 데이터가 없다면 데이터를 불러옴)
            // 2. FileInputStream 으로부터  read(byte[]) 를 사용해서 버퍼의 크기만큼 데이터를 불러온 뒤 보관
            // 3. 버퍼에 있는 데이터 중에 1byte를 반환 
            // 위의 과정을 반복

            //fileSize++;
        }
        bufferedInputStream.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File name:" + FILE_NAME);
        System.out.println("File size: " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms"); //141ms
        // BufferedXXX 클래스들은 동기화가 적용돼있어서, 싱글스레드 환경에서는 직접 버퍼를 다루는 것보다 성능이 떨어짐
        // 싱글스레드환경에서, 매우 큰 데이터를 다루고, 성능 최적화가 중요 시 step2처럼 직접 버퍼를 다루는 방법 고려
        // 꼭 필요한 상황이면 BufferedXxx 를 참고해서 동기화 락 코드를 제거한 클래스를 직접 만들어서 사용하자

    }
}
/* 상속구조
FileInputStream -> InputStream
BufferedInputStream -> InputStream
*/