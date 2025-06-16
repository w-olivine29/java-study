package ch10method.example;

// 각 학생의 평균점수 출력
public class MethodEx1 {
    public static void main(String[] args) {
        int[][] scores = {
                {90, 20, 40, 50},
                {55, 100, 20, 30, 100},
                {70, 80, 80}
        };

        for (int i = 0; i < scores.length; i++) {


            int sum = 0;
            int totalCnt = scores[i].length;
            for (int j = 0; j < totalCnt; j++) {
                sum += scores[i][j];
            }

            System.out.printf(
                    "[%d번 학생] 응시과목개수: %d, 총점: %d, 평균: %.2f\n",
                    (i + 1), totalCnt, sum, (double) sum / totalCnt);
        }

    }

    static double average(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (double) sum / nums.length;
    }
}
