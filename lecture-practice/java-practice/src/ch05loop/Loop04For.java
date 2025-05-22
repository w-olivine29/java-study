package ch05loop;

public class Loop04For {
    public static void main(String[] args) {

        // i부터 하나씩 증가하는 수를 endNum 까지 더하기
        int sum = 0;
        int endNum = 55;
        for (int i = 1; i <= endNum; i++) {
            System.out.println(sum += i);
        }

        sum = 0;
        System.out.println("=================================");

        // 1부터 시작하여 숫자를 계속 누적해서 더하다가 합계가 10보다 큰 처음 값은?
        for (int i = 1; ; i++) { // -> 무한반복
            if (sum > 10) {
                System.out.println("처음으로 10보다 큰 값은 " + sum);
                break;
            }
            sum += i;
        }
    }
}
