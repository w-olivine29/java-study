package ch05loop;

public class Loop01While1_2 {
    public static void main(String[] args) {
        // 1부터 하나씩 증가하는 수를 3번 더하기 (1 + 2 + 3)
        int cnt = 0, sum = 0;

        while (cnt < 3) {
            sum += ++cnt;
            System.out.printf("cnt: %d, sum: %d\n", cnt, sum);
        }

        System.out.println("\n==========================================");
        // i부터 하나씩 증가하는 수를 endNum 까지 더하기
        sum = 0;
        int i = 1;
        int endNum = 10;
        while (i <= endNum) {
            System.out.println("i: " + i + ", sum: " + (sum += i++));
        }

    }
}
