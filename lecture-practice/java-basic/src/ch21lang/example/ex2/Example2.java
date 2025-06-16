package ch21lang.example.ex2;

//배열에 입력된 모든 숫자의 합 구하기 (실수가 입력될 수 있음)
public class Example2 {
    public static void main(String[] args) {
        String[] arr = {"11", "1", "3.3", "7.0", "44.4"};

        double sum = 0;
        for (String s : arr) {
            sum += Double.parseDouble(s);
        }
        System.out.println("sum = " + sum);

    }
}
