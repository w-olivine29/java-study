package ch04condition.example;

/**
 * 삼항연산자
 * 홀짝
 */
public class ConditionEx5 {
    public static void main(String[] args) {

        int num1 = 7;
        int num2 = 2;

        String choice = "짝수";
        int result = 0;

        if (!(choice.equals("홀수") || choice.equals("짝수"))) {
            System.out.println("다시 선택해주세요.");
        } else {
            if (choice.equals("홀수")) {
                result = (num1 % 2 != 0) ? num1 : num2;
            } else {
                result = (num1 % 2 == 0) ? num1 : num2;
            }
            System.out.printf("%d 와 %d 중 %s는 %d 입니다.", num1, num2, choice, result);
        }


    }
}
