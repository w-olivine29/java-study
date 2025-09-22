package day7;

import java.io.IOException;
import java.util.Scanner;

public class SystemIO {
    public static void main(String[] args){

        try(Scanner scanner = new Scanner(System.in)){
            systemOutExample();

            systemInExample();
            scanner.nextLine();

            scannerExample(scanner);
            calculator(scanner);
        }catch (IOException e){
           e.printStackTrace();
        }

    }

    // 실습 중 한 메서드 내에서 중복되는 변수문제 때문에 메서드로 분리하였음
    private static void systemOutExample() {

        System.out.println("[System.out]");

        System.out.println("=== print 문자열 출력 ===");
        int number = 10;
        String text = "자바";
        System.out.print(number);
        System.out.print(text);
        System.out.println();

        System.out.println("=== println 문자열 출력 후 개행 ===");
        System.out.println("첫 번째 줄");
        System.out.println("두 번째 줄");


        System.out.println("=== printf() 포맷팅 출력 ===");
        String name = "홍길동";
        int age = 20;
        double height = 175.5;

        System.out.printf("이름 : %s\n", name);
        System.out.printf("나이 : %d\n", age);
        System.out.printf("키 : %.1f\n", height);
    }

    private static void systemInExample() throws IOException {
        System.out.println("[System.in]");

        // 한 바이트 읽기
        System.out.print("문자(char) 입력 : ");
        int input = System.in.read(); //InputStream

        // 읽은 값 출력
        System.out.println("입력한 문자 : " + (char) input);
        System.out.println("아스키 코드값 : " + input);
    }

    private static void scannerExample(Scanner scanner) {
        // 학생 정보 입력 프로그램 만들기

        System.out.println("학생 정보를 입력하세요.");
        System.out.print("이름 : ");
        String name = scanner.nextLine();

        System.out.print("학년 : ");
        int grade = scanner.nextInt(); // 숫자만 가져감 (입력한 개행문자는 남아있음)

        scanner.nextLine(); // 남아있는 개행문자 소모

        System.out.print("반 : ");
        String className = scanner.nextLine();

        // 입력 정보 출력
        System.out.println("\n== 학생 정보 ==");
        System.out.println("이름 : " + name);
        System.out.println("학년 : " + grade);
        System.out.println("반 : " + className);
        System.out.println();

    }

    private static void calculator(Scanner scanner){

        // 첫 번째 숫자 입력
        System.out.print("첫 번째 숫자: ");
        int num1 = scanner.nextInt();

        // 연산자 입력
        System.out.print("연산자(+,-,*,/): ");
        String op = scanner.next();

        // 두 번째 숫자 입력
        System.out.print("두 번째 숫자:");
        int num2 = scanner.nextInt();

        // 결과 계산 및 출력
        if (op.equals("+")) {
            System.out.println("결과 : " + (num1 + num2));
        } else if (op.equals("-")) {
            System.out.println("결과 : " + (num1 - num2));
        } else if (op.equals("*")) {
            System.out.println("결과 : " + (num1 * num2));
        } else if (op.equals("/")) {

            if (num2 != 0) {
                System.out.println("결과 : " + (num1 / num2));
            } else {
                System.out.println("0으로 나눌 수 없습니다.");
            }
        } else {
            System.out.println("잘못된 연산자입니다.");
        }
        System.out.println();
    }
}
