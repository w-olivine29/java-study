package ch02lambda.practice.ex2;

/* 값 매개변수화 - 다양한 단위를 매개변수로 받기

주어진 숫자를 특정단위로 출력하는 간단한 메서드이다.
숫자와 단위를 나누고 재사용 가능한 메서드를 사용하도록 수정하기
*/
public class Ex2After {

    public static void print(int weight, String unit) {
        System.out.printf("무게: %d %s\n", weight, unit);
    }

    public static void main(String[] args) {
        print(10, "kg");
        print(50, "kg");
        print(200,"g");
        print(40,"g");
    }
}