package ch09array.example;

import java.util.Scanner;

/**
 * 사용자에게 n명의 학생의 국어, 수학, 영어 점수를 입력받아 각 학생의 총점과 평균 계산
 */
public class ArrayEx5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] subjects = {"국어", "수학", "영어"};

        System.out.println("학생 수를 입력하시오. ");
        int[][] scores = new int[scanner.nextInt()][subjects.length];

        for (int i = 0; i < scores.length; i++) {

            System.out.println("=========== " + (i + 1) + "번 학생 과목 입력 ===========");
            for (int sub = 0; sub < subjects.length; sub++) {
                System.out.print(subjects[sub] + " 점수 입력: ");
                scores[i][sub] = scanner.nextInt();
            }
        }

        for (int i = 0; i < scores.length; i++) {

            int sum = 0;
            System.out.println("\n" + i + "번 학생: ");
            for (int j = 0; j < subjects.length; j++) {
                sum += scores[i][j];
                System.out.printf("[%d] ", scores[i][j]);
            }
            System.out.printf("=> 총점: %d, 평균: %.2f \n", sum, ((double) sum / subjects.length));
        }
    }
}
