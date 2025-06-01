package ch21lang.example.ex1;

// 문자열로 입력된 str1, str2 두 수의 합 구하기
public class Example1 {
    public static void main(String[] args) {

        String str1 = "10";
        String str2 = "30";

        //1
        int result = Integer.parseInt(str1) + Integer.parseInt(str2);
        System.out.printf("%s + %s = %d\n", str1, str2, result);

        //2
        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);

        result = Integer.sum(num1, num2);
        System.out.printf("%d + %d = %d\n", num1, num2, result);
    }
}
