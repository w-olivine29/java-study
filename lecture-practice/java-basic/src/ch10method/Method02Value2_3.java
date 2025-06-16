package ch10method;

public class Method02Value2_3 {

    public static void main(String[] args) {

        int num = 10;
        System.out.println("1. before changeNumber num = " + num);

        num = changeNumber(num);
        System.out.println("2. after changeNumber num = " + num); // 10

        System.out.println("num = " + num);

    }

    static int changeNumber(int num) {
        return num *= 2;

    }


}
