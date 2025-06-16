package ch03operator.example;


public class OperationEx {
    public static void main(String[] args) {

        System.out.println("\n==== int 와 평균 =============");
        int i1 = 10, i2 = 20, i3 = 30;

        int intSum = i1 + i2 + i3;
        int intAvg = intSum / 3;
        System.out.printf("sum = %d, average = %d \n", intSum, intAvg);


        System.out.println("\n==== double 와 평균 =============");
        double d1 = 1.1, d2 = 1.2, d3 = 1.3;

        double doubleSum = d1 + d2 + d3;
        double doubleAvg = doubleSum / 3;
        System.out.printf("doubleSum = %f, doubleAvg = %f \n", doubleSum, doubleAvg);

        System.out.println("\n==== 논리 연산자 + 비교 연산자 =============");
        int score = 70;
        boolean result = score >= 80 && score <= 100;
        System.out.println(score);


    }
}
