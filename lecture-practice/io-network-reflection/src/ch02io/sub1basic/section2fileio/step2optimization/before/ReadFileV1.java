package ch02io.sub1basic.section2fileio.step2optimization.before;

import java.io.FileInputStream;
import java.io.IOException;

import static ch02io.sub1basic.section2fileio.step2optimization.BufferedConst.FILE_NAME;
import static ch02io.sub1basic.section2fileio.step2optimization.BufferedConst.FILE_SIZE;

public class ReadFileV1 {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);

        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        int data;
        
        // 1 바이트씩 데이터를 읽어옴
        while ((data = fileInputStream.read()) != -1){
            fileSize++;
        }
        fileInputStream.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File name:" + FILE_NAME);
        System.out.println("File size: " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms"); //10203ms

    }
}
/*
10MB 파일에 대해 입출력 작업이 매우 오래 걸렸음
 이유) 자바에서 1바이트씩 디스크에 데이터를 전달하기 때문
       -> 1바이트씩 데이터를 받아서 1바이트 데이터를 씀 (약 1000만원 반복)

       -write(), read() 를 호출할때마다 OS의 시스템 콜을 통해 파일을 읽거나 쓰는 명령어 전달
       (이러한 시스템 콜은 상대적으로 무거운 작업)


       - HDD, SDD 같은 장치들도 하나의 데이터를 읽고 쓸때마다 필요한 시간이 있음
            - HDD의 경우 더욱 느림 (물리적으로 디스크의 회전필요)
    
    이러한 무거운 작업을 약 1000만원 반복하는 것이기 때문
    
    
이런식으로 자바에서 운영체제를 통해 디스크에 1바이트씩 전달할 때, 
실제로 디스크에 1바이트씩 계속 쓰는 것은 아님
(운영체제나 하드웨어 레벨에서 여러가지 최적화가 발생하기 때문)

그러나 자바에서 write() 나 read()를 호출할 때마다 운영 체제로의 시스템 콜 발생 
            -> 시스템 콜 자체가 상당한 오버헤드 유발 (최적화가 제공돼도, 시스템콜이 자주 발생하면, 성능 저하는 불가피)
                - 모드전환비용 (CPU 가 실행모드를 바꿔야함)
                - 컨텍스트스위칭
                - 검증 과정


!!!!따라서, 자바에서 read(), write() 호출 횟수를 줄여서 시스템 콜 횟수도 줄여야한다!!!
*/