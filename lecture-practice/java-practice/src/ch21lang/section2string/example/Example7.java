package ch21lang.section2string.example;

// 이메일의 id 부분과 도메인 분리하기
public class Example7 {
    public static void main(String[] args) {
        String email = "w.olivine29@gmail.com";

        // 내가 한 풀이
        System.out.println("아이디: " + getId(email));
        System.out.println("도메인: " + getDomain(email));
        
        // 해설
        String[] parts = email.split("@");
        System.out.println("id part: " + parts[0]);
        System.out.println("domain part: " + parts[1]);


    }

    private static String getId(String email) {
        return email.substring(0, email.indexOf("@"));
    }

    private static String getDomain(String email) {
        return email.substring(email.indexOf("@") + 1);
    }
    
}
