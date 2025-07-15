package ch02io.sub1basic.section2fileio.step1start;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayStreamMain {
    public static void main(String[] args) throws IOException {
        byte[] input = {1, 2, 3};

        // 메모리에 쓰기 (메모리 어딘가의 공간에 저장)
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(input);
        //outputStream.close(); //불필요

        // 메모리에서 읽기
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        byte[] bytes = inputStream.readAllBytes();
        System.out.println(Arrays.toString(bytes));

        //outputStream.close(); //불필요

        /* ByteArrayStream은 close() 호출할 필요 x
           
           - close() 가 empty 메서드인 상태
           - 메모리 스트림이기때문에
                - 외부자원 사용 x
                - OS레벨의 자원 사용 x
                - 단순히 메모리(바이트 배열) 에서만 동작)
                
        */
    }
}
