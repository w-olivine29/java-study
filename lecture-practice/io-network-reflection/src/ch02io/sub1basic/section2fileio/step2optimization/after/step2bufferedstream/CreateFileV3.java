package ch02io.sub1basic.section2fileio.step2optimization.after.step2bufferedstream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static ch02io.sub1basic.section2fileio.step2optimization.BufferedConst.FILE_NAME;
import static ch02io.sub1basic.section2fileio.step2optimization.BufferedConst.FILE_SIZE;

public class CreateFileV3 {
    public static void main(String[] args) throws IOException {

        // BufferedOutputStream 은 내부에서 단순히 버퍼기능만 제공 (보조스트림: 단독사용 불가, 보조기능 제공) 
        // -> 반드시 대상 OutputStream을 넣어줘야함 (기본스트림: 단독으로 사용가능)
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream); // BufferedOutputStream(OutputStream out, int size) 도 가능

        // 파일 생성 소요시간
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < FILE_SIZE; i++) {
            bufferedOutputStream.write(1);
            // 바로 파일에 작성이 아닌, 내부의 buffer 에 보관
            // buffer 가 가득 찰 때, FileOutputStream 의 write를 호출 (보관했던 모든 바이트를 시스템콜로 OS에 전달) 
            // buffer 의 데이터를 모두 전달 후에, 버퍼의 내용을 비움
            
            // 위의 내용을 반복
            
            // buffer 가 채워지지 않았을 때는 데이터를 전달하지 않음
            // 채워지지 않은 남은 데이터를 전달하기 위해서는 flush() 호출
        }
        bufferedOutputStream.close();
        // close() 호출 시 내부에서 flush 호출 -> BufferedOutputStream 자원 정리 -> FileOutputStream close() 호출  (close가 연쇄적으로 호출)
        // BufferedOutputStream 가 아닌, FileOutputStream를 직접 close() 하면, BufferedOutputStream 의 자원은 정리되지 않음 (버퍼에 남은 데이터도 저장x)
        
        long endTime = System.currentTimeMillis();

        System.out.println("File created:" + FILE_NAME);
        System.out.println("File size: " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms"); //150ms
        // BufferedXXX 클래스들은 동기화가 적용돼있어서, 싱글스레드 환경에서는 직접 버퍼를 다루는 것보다 성능이 떨어짐
        // 싱글스레드환경에서, 매우 큰 데이터를 다루고, 성능 최적화가 중요 시 step2처럼 직접 버퍼를 다루는 방법 고려
        // 꼭 필요한 상황이면 BufferedXxx 를 참고해서 동기화 락 코드를 제거한 클래스를 직접 만들어서 사용하자
    }
}
/* 상속구조
FileOutputStream -> OutputStream
BufferedOutputStream -> OutputStream
*/