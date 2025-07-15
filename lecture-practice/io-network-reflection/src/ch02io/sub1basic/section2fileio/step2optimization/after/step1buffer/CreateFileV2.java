package ch02io.sub1basic.section2fileio.step2optimization.after.step1buffer;

import java.io.FileOutputStream;
import java.io.IOException;

import static ch02io.sub1basic.section2fileio.step2optimization.BufferedConst.*;

//BufferedConst 의 BUFFER_SIZE 값 조절해가면서 사이즈에 따른 쓰기 성능 비교
public class CreateFileV2 {
    public static void main(String[] args) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);

        // 파일 생성 소요시간
        long startTime = System.currentTimeMillis();

        // Buffer: 데이터를 모아서 전달 or 모아서 전달받는 용도로 사용하는 것
        byte[] buffer = new byte[BUFFER_SIZE];

        int bufferIndex = 0;
        for (int i = 0; i < FILE_SIZE; i++) {
            buffer[bufferIndex++] = 1;

            // 버퍼가 가득 차면 쓰고, 버퍼를 비운다
            if (bufferIndex == BUFFER_SIZE) {
                fileOutputStream.write(buffer);
                bufferIndex = 0;
            }
        }
        // 끝 부분에 오면 버퍼가 가득차지 않고, 남아있을 수 있음  -> 버퍼에 남은 부분 쓰기
        if (bufferIndex > 0) {
            fileOutputStream.write(buffer, 0, bufferIndex);
        }
        fileOutputStream.close();

        long endTime = System.currentTimeMillis();

        System.out.println("File created:" + FILE_NAME);
        System.out.println("File size: " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}

/*   BUFFER_SIZE 에 따른 쓰기 성능
      - 1 -> 38667ms
      - 2 -> 20065ms
      - 3 -> 13387ms
      - 10 -> 3963ms
      - 100 -> 439ms
      - 1000 -> 62ms
      - 2000 -> 39ms
      - 4000 -> 29ms
      - 8000 -> 19ms
      - 80000 -> 11ms


버퍼 사이즈에 비례해서 성능이 증가
(시스템 콜 횟수 감소, HDD, SSD 같은 장치들의 작동 횟수 감소)

그러나 버퍼의 크기가 커진다고 해서 속도가 계속 줄어들지는 않음
  디스크나 파일 시스템에서 데이터를 읽고 쓰는 기본 단위가 4KB or 8KB 이기 때문
  4KB(4096 byte), 8KB(8192 byte)
  
버퍼에 많은 데이터를 담아도
디스크나 파일 시스템에서 해당 단위로 나누어 저장 -> 효율 한계

-> 결국 버퍼의 크기는 이에 맞게 4KB or 8KB 로 잡는 것이 효율적
*/
