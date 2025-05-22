package ch09array.example;

import java.util.Scanner;

/**
 * 사용자에게 정수를 입력받아 배열에 저장 후 저장 역순으로 출력
 * 출력 포멧은 , 를 사용하여 구분하고 마지막에는 쉼표 x
 */
public class ArrayEx2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("저장할 정수의 개수를 입력:  ");
        int[] arr = new int[scanner.nextInt()];

        System.out.println("입력한 개수만큼 정수를 입력하시오.");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        // 출력
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
    }
}
