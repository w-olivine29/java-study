package ch12reference;

public class Ref01VarChange1 {
    public static void main(String[] args) {

        System.out.println("=== b에 a 대입 ===============================");
        int a = 10;
        int b = a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println("=== a 변경 ===============================");
        a = 20;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println("=== b 변경 ===============================");
        b = 30;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }
}
