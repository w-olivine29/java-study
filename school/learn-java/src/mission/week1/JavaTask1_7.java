package mission.week1;

// 41기 - 유도경
public class JavaTask1_7 {
    public static void main(String[] args) {

        String[][] words = {
                {"어제", "내일"},
                {"나는", "동생은"},
                {"여행을", "학교에"},
                {"다녀왔다", "갈 예정이다"}
        };

        System.out.println(sentence(words, 0));
        System.out.println(sentence(words, 1));
    }

    private static String sentence(String[][] words, int index) {
        StringBuilder br = new StringBuilder(String.format("문장 %d: ", index + 1));
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1) {
                br.append(words[i][index]);
            } else {
                br.append(words[i][index]).append(" ");
            }
        }
        return br.toString();
    }
}
