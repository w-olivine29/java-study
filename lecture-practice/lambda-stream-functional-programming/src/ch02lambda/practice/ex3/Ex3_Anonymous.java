package ch02lambda.practice.ex3;


import java.util.Arrays;

/* 동작 매개변수화 - 익명 클래스로 다른 로직 전달

1부터 N까지 더하는 로직, 배열을 정렬하는 로직을 각각 실행 후,
이 두 가지 로직 모두 실행에 걸린 시간을 측정

해당 문제는 익명클래스를 이용하여 풀기

measure 메서드 안에서 
실행 전 시간 기록
로직 실행
실행 후 시간 기록

*/
public class Ex3_Anonymous {

    public static void measure(Procedure procedure) {
        long startTime = System.currentTimeMillis();

        // 로직
        procedure.run();

        long endTime = System.currentTimeMillis();
        System.out.println("소요시간: " + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) {

        // 1부터 N까지 더하는 로직
        measure(new Procedure() {
            @Override
            public void run() {
                int N = 10;

                int sum = 0;
                for (int i = 1; i <= N; i++) {
                    sum += i;
                }
                System.out.printf("1부터 %d까지 더한 값: %d\n", N, sum);
            }
        });

        // 배열을 정리하는 로직
        measure(new Procedure() {
            @Override
            public void run() {
                int[] arr = {4,3,2,1,6};
                System.out.println("before: " + Arrays.toString(arr));
                Arrays.sort(arr);
                System.out.println("after: " + Arrays.toString(arr));
            }
        });

    }

    @FunctionalInterface
    interface Procedure {
        void run();
    }
}
