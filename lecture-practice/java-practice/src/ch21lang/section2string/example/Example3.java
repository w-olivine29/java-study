package ch21lang.section2string.example;

// 문자열에서 ".exe" 이 언제부터 시작하는지 위치를 출력
public class Example3 {
    public static void main(String[] args) {
        String[] executableFileName = {
                "ideaIC-2025.1.1.1.exe",
                "Obsidian-1.8.10.exe ",
                "typora-setup-x64.exe"};
        printFileNameLength(executableFileName, ".exe");
    }

    private static void printFileNameLength(String[] arr, String extension) {
        for (String s : arr) {
            System.out.println(s + " 파일이름 길이: " + s.indexOf(extension));
        }
    }
}

