package ch10method;

// 자바는 항상 변수의 값을 복사해서 대입
public class Method02Value1 {
    public static void main(String[] args) {

        int num1 = 10;
        int num2 = num1;  // num1의 값을 복사하여 num2에 대입 (num1 자체가 들어가는 것이 아님)
        num2 = 20;

        System.out.println("num1 = " + num1); //10
        System.out.println("num2 = " + num2); //20


    }
}
