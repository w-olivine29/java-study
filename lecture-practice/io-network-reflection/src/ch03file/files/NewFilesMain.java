package ch03file.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class NewFilesMain {
    public static void main(String[] args) throws IOException {


        Path file = Path.of("io-network-reflection/temp/example.txt");
        Path directory = Path.of("io-network-reflection/temp/exampleDir.txt");

        // exists(): 파일이나 디렉토리의 존재 여부를 확인
        System.out.println("File exist = " + Files.exists(file));


        // createFile(): 새 파일을 생성
        try {
            Files.createFile(file);
            System.out.println("File created");

        } catch (FileAlreadyExistsException e) {
            System.out.println(file + "File already exist");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //  createDirectory(): 새 디렉토리를 생성
        try {
            Files.createDirectory(directory);
        } catch (FileAlreadyExistsException e) {
            System.out.println(directory + "Directory already exist");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        Files.delete(file);
//        System.out.println("File deleted");

        //isRegularFile(): 일반 파일인지 확인
        System.out.println("Is regular file: " + Files.isRegularFile(file));

        // isDirectory(): 디렉토리인지 확인
        System.out.println("Is directory: " + Files.isDirectory(directory));

        // getFileName(): 파일이나 디렉토리의 이름을 반환
        System.out.println("File name: " + file.getFileName());

        // size(): 파일의 크기를 바이트 단위로 반환
        System.out.println("File size: " + Files.size(file) + " bytes");

        // move(): 파일의 이름을 변경하거나 이동
        Path newFile = Paths.get("io-network-reflection/temp/newExample.txt");
        Files.move(file, newFile, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File moved/renamed");

        // getLastModifiedTime(): 마지막으로 수정된 시간을 반환
        System.out.println("Last modified: " + Files.getLastModifiedTime(newFile));

        // 추가: readAttributes(): 파일의 기본 속성들을 한 번에 읽기
        BasicFileAttributes attrs = Files.readAttributes(newFile, BasicFileAttributes.class);
        System.out.println("===== Attributes =====");
        System.out.println("Creation time: " + attrs.creationTime());
        System.out.println("Is directory: " + attrs.isDirectory());
        System.out.println("Is regular file: " + attrs.isRegularFile());
        System.out.println("Is symbolic link: " + attrs.isSymbolicLink());
        System.out.println("Size: " + attrs.size());
    }

}
