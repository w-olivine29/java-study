package ch02io.sub1basic.section4etc;

import java.io.*;

public class DataStreamEtcMain {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("io-network-reflection/temp/data.dat");
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

        dataOutputStream.writeUTF("회원A");
        dataOutputStream.writeInt(20); // int 4바이트로 저장
        dataOutputStream.writeDouble(20.0); // double 8바이트로 저장
        dataOutputStream.writeBoolean(true);

        dataOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("io-network-reflection/temp/data.dat");
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        
        // 반드시 저장한 순서대로 읽기
        System.out.println("dataInputStream.readUTF() = " + dataInputStream.readUTF());
        System.out.println("dataInputStream.readInt() = " + dataInputStream.readInt());
        System.out.println("dataInputStream.readDouble() = " + dataInputStream.readDouble());
        System.out.println("dataInputStream.readBoolean() = " + dataInputStream.readBoolean());
    }
}
/*
 회원A   @4      
 
 파일을 직접 열어보면 제대로 보이지 않음
 writeUTF 의 경우 UTF-8 형식으로 저장하나, 
 나머지는 문자가 아닌 각 타입에 마즌ㄴ byte 단위로 그대로 저장하기 때문
 
 텍스트 편집기는 자신의 문자 집합을 사용해서 byte를 문자로 표현시도
 but 문자집합에 없는 단어이거나 전혀 예상하지 않은 문자로 디코딩 될 것임
*/
