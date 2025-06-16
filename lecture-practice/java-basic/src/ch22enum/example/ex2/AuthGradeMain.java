package ch22enum.example.ex2;

/* 인증 등급 열거형 조회하기
ex1에서 만든 AuthGrade를 활용하여 모든 등급을 조회
*/
public class AuthGradeMain {
    public static void main(String[] args) {

        AuthGrade[] values = AuthGrade.values();
        for (AuthGrade value : values) {
            value.printProperties();
        }
    }
}
