package ch10method;

// 자바는 항상 변수의 값을 복사해서 대입
public class Method02Value2_1 {

    public static void main(String[] args) {

        int num1 = 10;
        System.out.println("1. before changeNumber num1 = " + num1);

        changeNumber(num1);
        System.out.println("num1 = " + num1); //10

    }

    static void changeNumber(int num2) {
        System.out.println("2. before changeNumber num2 = " + num2); // 10
        num2 *= 2;
        System.out.println("3. after changeNumber num2 = " + num2); //20

    }


}
