package ch03operator;

public class Operator01 {
    public static void main(String[] args) {
        // 변수 초기화
        int a = 5;
        int b = 2;

        System.out.println("===== 덧셈 ==============================");
        int sum = a + b;
        System.out.println("a + b = " + sum); // a+b = sum
        System.out.println("sum + sum = " + sum + sum);
        System.out.println("sum + sum = " + (sum + sum));


        System.out.println("===== 뺄셈 ==============================");
        int diff = b - a;
        System.out.println("b - a = " + diff);


        System.out.println("===== 곱셈 ==============================");
        int multi1 = b * -a;
        System.out.println("b * -a = " + multi1);

        int multi2 = -b * -a;
        System.out.println("-b * -a = " + multi2);

        int multi3 = -(-b * -a);
        System.out.println("-(-b * -a) = " + multi3);



        System.out.println("===== 나눗셈 ==============================");
        // int 끼리의 계산은 소숫점이 표현되지 않는다.
        int div1 = b / a;
        System.out.println("b * -a = " + div1);

        int div2 = a / b;
        System.out.println("a / b = " + div2);


        // 0으로 나누는 것은 불가 (0을 나누는 것은 상관없음)
        //System.out.println(a / 0); // / by zero -> ArithmeticException

        System.out.println(0 / 7);


        System.out.println("===== 나머지 ==============================");
        int mod = a % b;
        System.out.println("a % b = " + mod);
    }
}
