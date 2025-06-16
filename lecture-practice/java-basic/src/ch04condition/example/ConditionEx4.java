package ch04condition.example;

/**
 * 삼항연산자
 * 더 작은 숫자 찾기
 * 두 개의 정수 변수 중 더 작은 숫자를 출력
 */
public class ConditionEx4 {
    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 20;

        int min = (num1 < num2) ? num1 : num2;
        System.out.printf("%d 와 %d 중 더 작은 수는 %d 입니다.", num1, num2, min);
    }
}
