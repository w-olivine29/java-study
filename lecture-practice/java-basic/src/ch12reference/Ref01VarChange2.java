package ch12reference;

public class Ref01VarChange2 {
    public static void main(String[] args) {

        Data data1 = new Data();
        data1.value = 10;
        Data data2 = data1;


        System.out.println("=== data2에 data1 대입 ===============================");
        System.out.println("data1 주소값 = " + data1);
        System.out.println("data2 주소값 = " + data2);

        System.out.println("=== data1.value 변경 ===============================");
        data1.value = 20;
        System.out.println("data1.value = " + data1.value);  //20
        System.out.println("data2.value = " + data2.value);  //20

        System.out.println("=== data2.value 변경 ===============================");
        data1.value = 30;
        System.out.println("data1.value = " + data1.value);  //30
        System.out.println("data2.value = " + data2.value);  //30
    }
}
