package ch17memory.section01memory;


public class HeapMain {
    public static void main(String[] args) {
        System.out.println("main start");
        method1(1);
        System.out.println("main end\n");
    }

    static void method1(int m1) {
        System.out.println("\nMain1.method1 start");
        Data data = new Data(5);

        method2(data);
        // method2 실행완료 후 method2의 스택 프레임 제거
        // data(method2의 지역변수)도 함께 제거

        System.out.println("Main1.method1 end\n");
        // method1이 실행완료 되면서 data(method1의 지역변수)가 제거
        // 해당 인스턴스의 참조변수가 남아있지 않음 -> GC가 언제든 heap 메모리에서 삭제할 수 있는 상태가 되었음
    }

    static void method2(Data data) {
        System.out.println("\nMain1.method2 start");
        System.out.println("data = " + data);
        System.out.println("Main1.method2 end\n");
    }

    /*
    main start

    Main1.method1 start

    Main1.method2 start
    data = ch17memory.section01memory.Data@2f4d3709
    Main1.method2 end

    Main1.method1 end

    main end
    */

}
