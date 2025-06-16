package ch21lang.section2string.example;

// url이 https:// 로 시작하는지 확인
public class Example1 {
    public static void main(String[] args) {
        String myGithubUrl = "https://github.com/w-olivine29";
        System.out.println(myGithubUrl + " -> https 여부: " + verifyHttps(myGithubUrl));

        String suspiciousUrl = "http://www.coupang.com";
        System.out.println(suspiciousUrl + " -> https 여부: " + verifyHttps(suspiciousUrl));

    }

    private static boolean verifyHttps(String url) {
        return url != null && url.startsWith("https://");
    }
}
