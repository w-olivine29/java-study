package ch17memory.example.ex2;

public class MathArrayUtils {

    // 객체생성 방지
    private MathArrayUtils() {
    }

    public static int getSum(int[] arr) {

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    public static double getAverage(int[] arr) {
        return (double) getSum(arr) / arr.length;

    }

    public static int getMax(int[] arr) {

        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (max < i) max = i;

        }
        return max;
    }

    public static int getMin(int[] arr) {

        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            if (min > i) min = i;
        }
        return min;
    }


}
