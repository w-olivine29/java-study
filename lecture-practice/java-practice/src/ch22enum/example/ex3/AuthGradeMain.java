package ch22enum.example.ex3;

import ch22enum.example.ex1.AuthGrade;

import java.util.Scanner;

import static ch22enum.example.ex3.AuthGrade.*;

/* 인증 등급 열거형 활용
- 인증 등급을 입력 받아서 AuthGrade 열거형으로 변환
- 인증 등급에 따라 접근할 수 있는 화면 상이
    - GUEST) 메인화면
    - LOGIN) 메인화면, 이메일관리화면
    - ADMIN) 메인화면, 이메일관리화면, 관리자화면
*/
public class AuthGradeMain {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] screens = {"메인화면", "이메일 관리 화면", "관리자 화면"};

        AuthGrade authGrade;
        System.out.print("등급 입력 [GUEST, LOGIN, ADMIN]: ");

        while (true) {
            try {
                String gradeName = scanner.nextLine();
                authGrade = AuthGrade.valueOf(gradeName.toUpperCase());
                break;
            } catch (Exception e) {
                System.out.println("존재하지 않는 등급입니다. 다시 입력해주세요");
            }
        }

        System.out.println("당신의 등급은 " + authGrade.getDescription());
        System.out.println("=== 메뉴 목록 ===");
        //printScreen(authGrade, screens);

        printScreen(authGrade);
    }

//    private static void printScreen(AuthGrade authGrade, String[] screens) {
//        for (int i = 0; i < authGrade.getLevel(); i++) {
//            System.out.println("- " + screens[i]);
//        }
//    }

    private static void printScreen(AuthGrade grade) {
        int level = grade.getLevel();

        if (level >= GUEST.getLevel()) System.out.println("- 메인화면");
        if (level >= LOGIN.getLevel()) System.out.println("- 이메일 관리 화면");
        if (level >= ADMIN.getLevel()) System.out.println("- 관리자 화면");
    }
}
