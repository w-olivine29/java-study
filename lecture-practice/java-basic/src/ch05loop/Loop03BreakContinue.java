package ch05loop;

public class Loop03BreakContinue {
    public static void main(String[] args) {
        // 1부터 시작하여 숫자를 누적해서 더하다가 합계가 10보다 처음으로 큰 값은?
        int num = 1;
        int sum = 0;
        while (true) {
            if (sum > 10) {
                System.out.println("10보다 처음으로 큰 값은 " + sum);
                break; // while문 자체를 탈출
            }
            System.out.printf("num: %d, sum: %d\n", num, (sum += num++));
        }

        System.out.println("====================================================");
        // 1부터 시작하여 maxNum 까지 출력하는데, 3의 배수일 때는 출력 건너뛰기
        int i = 1;
        int maxNum = 50;
        while (i <= maxNum) {
            if (i != 0 && i % 3 == 0) {
                i++;
                continue; //바로 다음 루프로 넘어감
            }
            System.out.println("i: " + i++);
        }
    }
}
