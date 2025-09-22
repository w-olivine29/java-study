package mission.week1;

// 41기 - 유도경
public class JavaTask1_5 {
    public static void main(String[] args) {
        int score1 = 70;
        int score2 = 59;

        System.out.println("score1: " + score1 + "점");
        System.out.println(resultIfElse(score1));
        System.out.println("삼항 연산자 : " + resultTrinomial(score1));


        System.out.println("\nscore2: " + score2 + "점");
        System.out.println(resultIfElse(score2));
        System.out.println("삼항 연산자 : " + resultTrinomial(score2));



    }


    private static String resultIfElse(int score) {
        String result;
        if (score >= 60) {
            result = "합격!";
        } else {
            result = "불합격!";
        }
        return result;
    }

    private static String resultTrinomial(int score) {
        return (score >= 60) ? "합격!" : "불합격!";
    }
}
