package ch08scanner;

import java.util.Scanner; // java.util 라이브러리

public class Scanner1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("문자열을 입력하세요: ");
        String inputStr = scanner.nextLine(); // (\n)개행문자를 입력할때 까지만 문자를 가져옴 (\n까지 읽어들임)

        // nextInt(),nextDouble() 등은 숫자 + (\n)엔터를 입력할때 까지 숫자를 가져옴 (\n는 안 읽어들임)
        System.out.print("정수를 입력하세요: ");
        int inputInt = scanner.nextInt();

        System.out.print("실수를 입력하세요: ");
        double inputDouble = scanner.nextDouble();

        System.out.println("\n당신이 입력한 문자열: " + inputStr);
        System.out.println("당신이 입력한 정수: " + inputInt);
        System.out.println("당신이 입력한 실수: " + inputDouble);

        //주의 ==========================================================
        System.out.print("\n정수를 입력하세요: ");
        int inputInt2 = scanner.nextInt();
        // enter(\n)를 누른 뒤 숫자만 받아들이고, 개행문자는 읽어들이지 않고 남은 상태

        System.out.print("문자열을 입력하세요: ");
        String inputStr2 = scanner.nextLine();
        // 바로 전에 nextInt() 에서 읽지않고 남아있던 개행문자를 바로 읽어버리고 다음 코드 실행

        System.out.println("당황하셨죠?");


        // nextLine() 을 사용해야하는데 개행문자가 남아있는 상황이라면 개행문자를 소비해놔야함
        System.out.print("\n정수를 입력하세요: ");
        int inputInt3 = scanner.nextInt();
        scanner.nextLine(); // 읽지않고 남은 개행문자 소비

        System.out.print("문자열을 입력하세요: ");
        String inputStr3 = scanner.nextLine();

        scanner.close();
    }
}
