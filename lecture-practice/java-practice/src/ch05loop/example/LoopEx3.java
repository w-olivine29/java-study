package ch05loop.example;

/* 누적 합 계산
1부터 max 까지의 합을 계산하고 출력
for문, while문 2가지 버전 만들기
* */
public class LoopEx3 {
    public static void main(String[] args) {

        int max = 10, sum = 0;

        for (int i = 0; i <= max; i++) {
            sum += i;
        }
        System.out.println("max = " + max + " -> " + sum);

        sum = 0;
        int cnt = 1;
        while (cnt <= max) {
            sum += cnt++;
        }
        System.out.println("max = " + max + " -> " + sum);
    }
}
