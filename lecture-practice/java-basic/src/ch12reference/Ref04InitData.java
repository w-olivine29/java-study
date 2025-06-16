package ch12reference;

public class Ref04InitData {

    int intValue1; //0
    int intValue2 = 10;

    double doubleValue1;  //0.0
    double doubleValue2 = 10.0;

    boolean booleanValue1;  //false
    boolean booleanValue2 = true;

    int[] arr1; //null
    int[] arr2 = new int[0];


    // 멤버변수의 경우 직접 초기화하지 않아도 객체생성시 JVM이 기본값으로 초기화해준다.
    public static void main(String[] args) {
        Ref04InitData data = new Ref04InitData();
        System.out.println("intValue1: " + data.intValue1);
        System.out.println("intValue2: " + data.intValue2);

        System.out.println("doubleValue1: " + data.doubleValue1);
        System.out.println("doubleValue2: " + data.doubleValue2);

        System.out.println("booleanValue1: " + data.booleanValue1);
        System.out.println("booleanValue2: " + data.booleanValue2);

        System.out.println("arr1: " + data.arr1);
        System.out.println("arr2: " + data.arr2);

    }
}
