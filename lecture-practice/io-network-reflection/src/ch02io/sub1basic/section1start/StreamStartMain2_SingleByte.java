package ch02io.sub1basic.section1start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain2_SingleByte {
    public static void main(String[] args) throws IOException {

/*       파일에 데이터를 출력하는 스트림
         append
             false(default): 실행 시 해당 경로의 파일의 내용을 지우거나, 파일이 없으면 파일을 생성
             true: 실행 시 해당 경로의 파일에 내용을 이어감, 파일이 없으면 파일 생성

        해당 경로가 존재하지 않으면 예외발생 (폴더는 만들어주지 않음, 코드로 폴더 만들기는 나중에)*/
        FileOutputStream fileOutputStream = new FileOutputStream("io-network-reflection/temp/hello.dat", false); //.dat: data

        
        //write(int or byte[]) 을 받음
        // 해당 파일에 작성
        // 바이트 형태로 저장
        // 해당 파일에 들어가보면 디코딩된 형태를 볼 수 있다 (개발툴이나 텍스트 편집기가 문자집합을 사용하여 문자로 디코딩해서 보여줌)
        fileOutputStream.write(65); //입력: 숫자 65 ->  저장: 바이트 01000001 (여전히 숫자) -> 표시: 'A' (에디터가 ASCII로 해석)
        fileOutputStream.write(66); //B
        fileOutputStream.write(67); //C

        // 외부에 있는 자원을 가져다 쓰고 있는 것이기때문에 자원반납 (JVM 내부가 아닌 운영체제(OS) 레벨의 자원을 사용)
        // 자바의 내부 객체처럼 GC의 대상이 될 수 없음
        fileOutputStream.close();

        //=================================================================================
        // 파일에서 데이터를 읽어오는 스트림
        FileInputStream fileInputStream = new FileInputStream("io-network-reflection/temp/hello.dat");

        // 1바이트씩 읽어온다 -> int로 반환하는 이유 (pdf 참고)
        int data;
        while ((data = fileInputStream.read()) != -1) {
            System.out.println(data);
        }

        fileInputStream.close();
    }
}
