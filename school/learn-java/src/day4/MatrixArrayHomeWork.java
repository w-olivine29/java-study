package day4;

public class MatrixArrayHomeWork {

    public static void main(String[] args) {
        // 이차원 문자열 배열 생성
        String[][] words = {
                {"어제", "내일"},
                {"나는", "동생은"},
                {"여행을", "학교에"},
                {"다녀왔다", "갈 예정이다"}
        };

        // 위 문장을 가지고 아래의 완성된 문장을 만들어보세요. 
        // 어제 나는 여행을 다녀왔다
        // 내일 동생은 학교에 갈 예정이다

        // 첫 번째 문장 만들기 (어제 + 나는 + 여행을 + 다녀왔다)
        String sentence1 = words[0][0] + " " +
                words[1][0] + " " +
                words[2][0] + " " +
                words[3][0];

        // 두 번째 문장 만들기 (내일 + 동생은 + 학교에 + 갈 예정이다)
        String sentence2 = words[0][1] + " " +
                words[1][1] + " " +
                words[2][1] + " " +
                words[3][1];

        // 결과 출력
        System.out.println("문장 1: " + sentence1);  // 어제 나는 여행을 다녀왔다
        System.out.println("문장 2: " + sentence2);  // 내일 동생은 학교에 갈 예정이다
    }

}
