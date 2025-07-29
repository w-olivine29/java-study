package ch02lambda.practice.ex3;


import java.util.Arrays;

/* Ex3_Anonymous -> 람다로 변경하기
 */
public class Ex3_Lambda {

    public static void measure(Procedure procedure) {
        long startTime = System.currentTimeMillis();

        // 로직
        procedure.run();

        long endTime = System.currentTimeMillis();
        System.out.println("소요시간: " + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) {

        // 1부터 N까지 더하는 로직
        measure(() -> {
                    int N = 10;

                    int sum = 0;
                    for (int i = 1; i <= N; i++) {
                        sum += i;
                    }
                    System.out.printf("1부터 %d까지 더한 값: %d\n", N, sum);
                }
        );


        // 배열을 정리하는 로직
        measure(() -> {
                    int[] arr = {4, 3, 2, 1, 6};
                    System.out.println("before: " + Arrays.toString(arr));
                    Arrays.sort(arr);
                    System.out.println("after: " + Arrays.toString(arr));
                });

    }

    @FunctionalInterface
    interface Procedure {
        void run();
    }
}
