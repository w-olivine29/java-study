package ch03operator;

public class Operator07Assignment {
    public static void main(String[] args) {
        int num1 = 10;
        System.out.println("num1 += 10 -> " + (num1 += 10)); //20
        System.out.println("num1 = " + num1); // 20

        num1 -= 5; //15
        num1 /= 5; //3
        num1 *= 4; //12
        num1 %= 3; //0
        System.out.println("num1 = " + num1);
    }
}
