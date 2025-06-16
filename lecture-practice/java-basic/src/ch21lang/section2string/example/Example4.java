package ch21lang.section2string.example;

// 문자열에서 확장자 부분, 파일이름 분리
public class Example4 {
    public static void main(String[] args) {
        String[] executableFileName = {
                "ideaIC-2025.1.1.1.app",
                "Obsidian-1.8.10.exe ",
                "typora-setup-x64.exe"};

        for (String fileName : executableFileName) {
            System.out.println("\n" + fileName);
            System.out.println("파일이름: " + getFileBaseName(fileName));
            System.out.println("확장자: " + getExtension(fileName));
        }
    }

    private static String getFileBaseName(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    private static String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }
}

