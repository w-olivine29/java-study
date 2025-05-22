package ch09array.example;

import java.util.Scanner;

/**
 * 사용자에게 n개의 정수를 입력받아 배열에 저장 후
 * 배열 내에서 가장 작은 수와 가장 큰 수를 찾아 출력
 */
public class ArrayEx4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("입력할 정수의 개수: ");
        int num = scanner.nextInt();

        int[] nums = new int[num];

        System.out.println(num + " 개의 정수를 입력하시오.");
        // === 배열에 모두 저장 후 비교 =================================================
/*        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }

        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }*/

        // === 배열에 저장하면서 비교 =================================================
        int max, min;
        max = min = scanner.nextInt();
        for (int i = 1; i < nums.length; i++) {
            nums[i] = scanner.nextInt();

            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        System.out.printf("max: %d, min: %d", max, min);
    }
}
