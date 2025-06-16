package ch17memory.section01memory;


public class StackMain {
    public static void main(String[] args) {
        System.out.println("main start");
        method1(1);
        System.out.println("main end\n");
    }

    static void method1(int m1) {
        System.out.println("\nMain1.method1 start");
        int cal = m1 * 2;
        method2(cal);
        System.out.println("Main1.method1 end\n");
    }

    static void method2(int m2) {
        System.out.println("\nMain1.method2 start");
        System.out.println("Main1.method2 end\n");
    }

    /*
    main start

    Main1.method1 start

    Main1.method2 start
    Main1.method2 end

    Main1.method1 end

    main end
    */

}
