package ch03file.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class OldFileMain {
    public static void main(String[] args) throws IOException {
        
        // 파일과 디렉토리 모두 File 객체로 다룸
        
        // File 객체를 만들었다고 파일, 디렉토리가 생성되는 것이 아님
        File file = new File("io-network-reflection/temp/example.txt");
        File directory = new File("io-network-reflection/temp/exampleDir");


        // exists(): 파일이나 디렉토리의 존재 여부를 확인
        System.out.println("File exist: " + file.exists());
        
        // createNewFile() 새 파일 생성
        // 이미 존재하는 경우는 false 반환
        boolean created = file.createNewFile();
        System.out.println("File created = " + created);

        // mkdir() 디렉토리 생성
        boolean dirCreated = directory.mkdir();
        System.out.println("Directory created = " + dirCreated);

        //delete(): 파일이나 디렉토리를 삭제
//        boolean deleted = file.delete();
//        System.out.println("File deleted = " + deleted);

        // isFile(): 파일인지 확인 &  isDirectory(): 디렉토리인지 확인
        System.out.println("Is file: " + file.isFile());
        System.out.println("Is directory: " + directory.isDirectory());

        //getName(): 파일이나 디렉토리의 이름을 반환
        System.out.println("file.getName() = " + file.getName()); //example.txt

        //length(): 파일의 크기를 바이트 단위로 반환
        System.out.println("file.length() = " + file.length());

        // renameTo(File dest) 파일 이름 바꾸기 (파일 객체를 넣어야함)
        File newFile = new File("io-network-reflection/temp/newExample.txt");
        boolean renamed = file.renameTo(newFile);

        System.out.println("File renamed = " + renamed);

        //lastModified(): 마지막으로 수정된 시간을 반환
        long lastModified = newFile.lastModified();
        System.out.println("lastModified = " + new Date(lastModified));


        // 파일 생성 시, 존재하지 않는 경로면?
        File nonPathFile = new  File("io-network-reflection/temp/none/file.txt");
       // nonPathFile.createNewFile();  //IOException: 지정된 경로를 찾을 수 없습니다
    }
}
