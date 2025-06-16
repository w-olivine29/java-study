package ch05loop.example;

/* 1부터 시작하여 처음 10개의 짝수 출력
for문, while문 2가지 버전 만들기
* */
public class LoopEx2 {
    public static void main(String[] args) {

        int num = 1;
        System.out.println("==== for문 =======================");
        for (int i = 1; i <= 10; i++) {
            if (num % 2 != 0) {
                num++;
                i--; // 홀수일 경우 반복문 횟수가 줄어들어선 안됨
                continue;
            }
            System.out.println(num++);
        }

        System.out.println("==== while문 =======================");

        // 무한루프에 빠진 풀이
/*        num = 1;
        int cnt = 1;
        while (cnt <= 10) {
            if (num % 2 == 0) {
                cnt++;
                System.out.println(num++);
                continue;
            }
            cnt--;
            num++;
        }*/

        num = 1;
        int cnt = 1;
        while (cnt <= 10) {
            cnt++;
            if (num % 2 == 0) {
                System.out.println(num++);
                continue;
            }
            cnt--;
            num++;
        }

    }
}
