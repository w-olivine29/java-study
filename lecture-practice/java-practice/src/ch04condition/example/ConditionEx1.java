package ch04condition.example;

/**
 * 학점계산
 * <p>
 * 90점 이상: "A"
 * 80점 이상 90점 미만: "B"
 * 70점 이상 80점 미만: "C"
 * 60점 이상 70점 미만: "D"
 * 60점 미만: "F"
 * <p>
 * ex)
 * score: 89
 * grade: B
 * <p>
 * 점수는 int로 지정, 해당 변수를 기반으로 학점 출력
 */
public class ConditionEx1 {
    public static void main(String[] args) {

        int score = 85;
        String grade;

        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        System.out.println("score: " + score);
        System.out.println("grade: " + grade);
    }
}
