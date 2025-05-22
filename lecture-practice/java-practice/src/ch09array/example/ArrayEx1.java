package ch09array.example;

import java.util.Scanner;

/**
 * 사용자에게 정수를 입력받아 배열에 저장 후 저장순서대로 출력
 * 출력 포멧은 , 를 사용하여 구분하고 마지막에는 쉼표 x
 */
public class ArrayEx1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("저장할 정수의 개수를 입력:  ");
        int[] nums = new int[scanner.nextInt()];

        System.out.println("입력한 개수만큼 정수를 입력하시오.");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }

//        for (int i = 0; i < nums.length; i++) {
//            if (i < nums.length - 1) {
//                System.out.print(nums[i] + ", ");
//            } else {
//                System.out.print(nums[i]);
//            }
//        }


        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]); // 공통되는 부분은 조건문 넣지 않는게 더 단순하고 깔끔

            if (i < nums.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
