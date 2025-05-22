package ch09array.example;

import java.util.Scanner;

/**
 * 사용자에게 n개의 정수를 입력받아 배열에 저장 후
 * 정수들의 합계와 평균 계산
 */
public class ArrayEx3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        System.out.print("입력할 정수의 개수 입력: ");
        int[] arr = new int[scanner.nextInt()];

        System.out.println("입력한 개수만큼 정수를 입력하시오.");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }

        System.out.printf("합계: %d,평균 %.1f", sum, ((double) sum / arr.length));
    }
}
