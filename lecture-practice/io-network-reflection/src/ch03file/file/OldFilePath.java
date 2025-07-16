package ch03file.file;

import java.io.File;
import java.io.IOException;

public class OldFilePath {
    public static void main(String[] args) throws IOException {

        // 경로에서 앞에 아무것도 없으면 프로젝트 자바를 실행하는 곳부터 시작된다
        // 실습 때 프로젝트 실행위치는 lecture-practice
        File file = new File("io-network-reflection/../..");
        System.out.println("path = " + file.getPath());

        // 절대 경로: 경로의 처음부터, 내가 입력한 모든 경로 다 표현
        System.out.println("Absolute path = " + file.getAbsolutePath());
        //C:\Users\USER\Documents\GitHub\java-study\lecture-practice\io-network-reflection\..\..

        // 정규 경로: 절대 경로에서, 경로의 계산이 모두 끝난 경로 (정규 경로는 하나만 존재)
        System.out.println("Canonical path = " + file.getCanonicalPath());
        //C:\Users\USER\Documents\GitHub\java-study

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println((f.isFile() ? "File" : "Directory") + "|" + f.getName());
        }
    }
}
