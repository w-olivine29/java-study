package ch27collection.section3list.example.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
문제2
  n개의 정수 입력 받고, List에 저장 후 입력 순서대로 출력
  0 입력시 입력 종료, 결과 출력
 출력시 포멧은 정수, 정수, 정수

문제3
  보관한 정수의 합계와 평균을 계산
*/
public class ListPrinter {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("저장할 정수를 입력하시오 (0 입력시 종료): ");
            int num = scanner.nextInt();
            if (num == 0) {
                System.out.println("종료");
                break;
            }
            list.add(num);
            System.out.println(); //개행문자 소모
        }

        printList(list);
        System.out.println("총합: " + sum(list));
        System.out.printf("평균: %.2f", average(list));
    }

    private static void printList(List<Integer> list) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }

    private static int sum(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

    private static double average(List<Integer> list) {
        return (double)sum(list) / list.size();
    }
}
