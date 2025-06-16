package ch21lang.section2string.example;

// 배열에 들어있는 모든 문자열의 길이 합 구하기
public class Example2 {
    public static void main(String[] args) {
        String[] vegetables = {"carrot", "cabbage ", "spinach", "lettuce", "broccoli"};

        System.out.println("vegetables 문자열들의 합: " + getStringSum(vegetables));
    }

    private static int getStringSum(String[] arr) {
        int result = 0;
        for (String s : arr) {
            System.out.println(s + "의 길이: " + s.length());
            result += s.length();
        }
        return result;
    }
}
