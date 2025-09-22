package day7;

import java.io.*;

/*
바이트 스트림
  1바이트 단위로 데이터 전송
  모든 종류 데이터 처리 가능
  주로 바이너리 데이터 처리 시 사용

InputStream & OutputStream
   바이트 기반 입력 & 출력 스트림의 최상위 추상 클래스
*/

// FileOutputStream 에 append 설정이 따로 없으면 덮어쓰기 모드
public class Stream {

    public static void main(String[] args) {
        fileInputStream();
        fileOutputStream();
        fileReaderWriter();
        bufferedReaderWriter();
    }


    // 1. fileInputStream 으로 byte 읽기
    private static void fileInputStream() {
        try (FileInputStream fis = new FileInputStream("test.txt")) { // 해당 파일이 없으면 예외발생
            int data;
            // 한 바이트씩 읽기
            while ((data = fis.read()) != -1) { // read(): EOF 구분을 위해 int 타입으로 반환
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2. FileOutputStream으로 byte 쓰기
    private static void fileOutputStream() {
        try (FileOutputStream fos = new FileOutputStream("output1111.txt")) { // 해당 파일이 없으면 새로 만듬 + 덮어쓰기모드
            String text = "Hello, Java!";
            byte[] bytes = text.getBytes();
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 3. fileReader로 한 문자씩 읽기 & fileWriter로 문자 쓰기
    private static void fileReaderWriter() {

        try (FileReader fr = new FileReader("test.txt")) { // 해당 파일이 없으면 예외발생
            int data;
            // 한 문자씩 읽기
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fw = new FileWriter("output22222.txt")) {  // 해당 파일이 없으면 새로 만듬 + 덮어쓰기모드
            fw.write("안녕하세요!\n");
            fw.write("자바입니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 4.BufferedReader로 한 줄씩 읽기 & BufferedWriter로 쓰기
    private static void bufferedReaderWriter() {
        //
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) { // 해당 파일이 없으면 예외발생
            String line;
            // 한 줄씩 읽기
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output4545455.txt",true))) {  // 해당 파일이 없으면 새로 만듬 + 내용 추가모드
            bw.write("첫 번째 줄");
            bw.newLine(); // 줄바꿈
            bw.write("두 번째 줄");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
