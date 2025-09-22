package day1to3;

public class For {

    public static void main(String[] args) {

        // 1. 구구단의 2단을 출력
        for (int i = 1; i <= 9; i++) {
            System.out.println(" 2 X " + i + " = " + (2 * i));
        }

        // 2. 합계 구하기
        // 1+2+3+4+5+6+7+8+9+10 = 55
        int sum2 = 0;
        for (int i = 1; i <= 10; i++) {
            sum2 += i;
        }
        System.out.println("1부터 10까지의 합 : " + sum2);


        // 2. while문
        int num2 = 1; // 초기화
        while (num2 <= 5) { // 조건식
            System.out.println(num2);
            num2++; // 증감식
        }

        // 2. 카운트 다운
        int count = 5;

        while (count > 0) {
            System.out.println(count);
            count--;
        }
        System.out.println("발사!");

        // 3. 무한루프
//        int i = 0;
//        while (true) {
//            System.out.println("무한루프 - 횟수 : " + i);
//            i++;
//        }


        // 3. break, continue
        // break
        int sum3 = 0;
        int num3 = 1;

        while (true) {
            sum3 += num3;
            if (sum3 > 100) {
                break;
            }
            num3++;
        }
        System.out.println("마지막에 더한 수 : " + num3);
        System.out.println("최종 합계 : " + sum3);

        // continue
        int number = 0;
        while (number < 10) {
            number++;
            if (number % 2 != 0) { // 홀수
                continue;
            }
            System.out.println(number); // 짝수
        }

        // 4. 구구단 작성
        for (int dan = 2; dan <= 9; dan++) { // 2단부터 9단까지 반복
            // 단수 표시
            System.out.println("\n" + dan + "단");

            // 1부터 9까지 곱하기
            for (int i = 1; i <= 9; i++) {
                System.out.println(dan + " x " + i + " = " + (dan * i));
            }
        }


        // 문제 : 1부터 100까지 반복을 사용해서 합을 구하기
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i; // sum = sum + i
        }
        System.out.println("1부터 100까지의 합 : " + sum);
    }
}