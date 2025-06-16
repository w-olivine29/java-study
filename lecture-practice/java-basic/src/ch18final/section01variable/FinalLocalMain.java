package ch18final.section01variable;

public class FinalLocalMain {
    public static void main(String[] args) {

        // final 지역변수1
        final int data1;
        data1 = 10; // 최초 한번만 할당 가능
        //data1 = 20;  // java: variable data1 might already have been assigned

        //final 지역변수2
        final int data2 = 10;
        //data2 = 20;
    }

    static void method(final int parameter) { // 인수가 넘어왔는데, 매개변수가 final이기때문에 변경불가
        //parameter = 20;
    }
}
