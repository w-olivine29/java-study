package ch04condition.example;

/**
 * 별점에 따른 음식점 추천
 * <p>
 * 카레전문점 - 3.8
 * 한식전문점 - 4.2
 * 서양국수 - 4.5
 * 중국점 - 2.8
 * <p>
 * ex)
 * 별점 3점 이상 (별점순)
 * 서양국수 - 4.5
 * 한식전문점 - 4.2
 * 카레전문점 - 3.8
 */
public class ConditionEx2 {
    public static void main(String[] args) {

        double curryRating = 3.8;
        double koreanRating = 4.2;
        double westernNoodleRating = 4.5;
        double chineseRating = 2.8;

        int minimumRating = 3;

        System.out.println(minimumRating + "점 이상 음식점 추천");
        if (minimumRating < 5) {
            System.out.printf("%s - %.1f점 \n", "서양국수", westernNoodleRating);
            System.out.printf("%s - %.1f점 \n", "한식전문점", koreanRating);
        }
        if (minimumRating < 4) {
            System.out.printf("%s - %.1f점 \n", "카레전문점", curryRating);
        }
        if (minimumRating < 3) {
            System.out.printf("%s - %.1d점 \n", "중국집", chineseRating);
        }

    }
}
