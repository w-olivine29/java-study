package ch03operator;

public class Operator03Priority {
    public static void main(String[] args) {

        int sum1 = 1 + 2 * 3; //7
        int sum2 = (1 + 2) * 3; //9
        int sum3 = 1 * 2 + 3 * 4; //14
        int sum4 = (1 * 2) + (3 * 4); // 결과는 sum3 과 같지만 명시적으로 표현하는것이 명확하고 단순

        System.out.println("sum1 = " + sum1);
        System.out.println("sum2 = " + sum2);
        System.out.println("sum3 = " + sum3);
        System.out.println("sum4 = " + sum4);

    }
}
