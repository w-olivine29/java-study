package ch03file.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class NewFilesPath {
    public static void main(String[] args) throws IOException {

        // 경로에서 앞에 아무것도 없으면 프로젝트 자바를 실행하는 곳부터 시작된다
        // 실습 때 프로젝트 실행위치는 lecture-practice
        Path path = Path.of("io-network-reflection/..");
        System.out.println("path = " + path);


        // 절대 경로: 경로의 처음부터, 내가 입력한 모든 경로 다 표현
        System.out.println("Absolute path = " + path.toAbsolutePath());
        //Absolute path = C:\Users\USER\Documents\GitHub\java-study\lecture-practice\io-network-reflection\..

        // 정규 경로: 절대 경로에서, 경로의 계산이 모두 끝난 경로 (정규 경로는 하나만 존재)
        System.out.println("Canonical path = " + path.toRealPath());
       //Canonical path = C:\Users\USER\Documents\GitHub\java-study\lecture-practice

        //입출력의 Stream 이 아님
        Stream<Path> pathStream = Files.list(path);
        List<Path> list = pathStream.toList();
        pathStream.close();

        for (Path p : list) {
            System.out.println((Files.isRegularFile(p) ? "File" : "Directory") + "|" + p.getFileName());
        }
    }
}
