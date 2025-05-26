package ch17memory.example.ex2;

// 배열의 모든 요소를 계산하는 클래스 만들기
// 합계, 평균값, 최솟값, 최댓값
public class MathArrayUtilsMain {
    public static void main(String[] args) {

        int[] arr = {10, 40, -50, 100, 20};

        System.out.println("합계: " + MathArrayUtils.getSum(arr));
        System.out.println("평균: " + MathArrayUtils.getAverage(arr));
        System.out.println("최솟값: " + MathArrayUtils.getMin(arr));
        System.out.println("최댓값: " + MathArrayUtils.getMax(arr));

    }
}
