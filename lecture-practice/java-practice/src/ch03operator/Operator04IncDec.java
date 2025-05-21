package ch03operator;

public class Operator04IncDec {
    public static void main(String[] args) {

        // 증감 연산자 (-- 는 동일하여 생략)
        int a = 1;
        a = a + 1;
        System.out.println("a = " + a); //2


        ++a; // a = a + 1; // 전위연산자
        a++; // a = a + 1; // 후위연산자

        System.out.println(a); //4

        int num1 = 10;
        int num2;

        System.out.println("==== 전위 연산자 =====================");
        num2 = ++num1; // num1의 값을 먼저 1증가한 값을 num1에 대입한 뒤 num2에 대입
        System.out.println("num2 = " + num2); //11


        System.out.println("==== 후위 연산자 =====================");
        num2 = num1++; // num1의 값을 num2에 대입한 뒤 num1을 1증가한 값을 num1에 대입
        System.out.println("num2 = " + num2); //11
        System.out.println("num1 = " + num1); // 12

    }
}
