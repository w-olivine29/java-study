package ch24nestedclasses.section3local.sub1.step2interface;

public class LocalOuter {

    private int outerInstanceVar = 10;


    public void process(int paramVar) {
        // 지역변수
        int localVar = 20;

        // 지역클래스는 접근제어자 사용불가
        // 지역클래스도 인터페이스 구현가능
        class LocalPrinter implements Printer {
            int value = 30;

            @Override
            public void print() {
                System.out.println("value = " + value);

                System.out.println("localVar = " + localVar);
                System.out.println("paramVar = " + paramVar);

                System.out.println("outerInstanceVar = " + outerInstanceVar);
            }
        }

        LocalPrinter localPrinter = new LocalPrinter();
        localPrinter.print();
    }

    public static void main(String[] args) {
        LocalOuter outer = new LocalOuter();
        outer.process(0);
    }
}
