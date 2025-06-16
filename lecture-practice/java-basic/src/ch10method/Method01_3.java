package ch10method;

public class Method01_3 {

    public static void main(String[] args) {

        System.out.println(odd(3));
        System.out.println(odd(2));

        System.out.println("===================================");

        checkAge(20);
        checkAge(11);
    }

    static boolean odd(int num) {
        return num % 2 != 0 ? true : false;
    }

    static void checkAge(int age) {
        if (age < 19) {
            System.out.println(age + "세: 19세 미만 출입 출가");
            return;
        }
        System.out.println(age + "세: 입장가능");
    }


}
