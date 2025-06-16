package ch24nestedclasses.section3local.sub1.step1start;

public class LocalOuter {

    private int outerInstanceVar = 10;


    public void process(int paramVar) {
        // 지역변수
        int localVar = 20;

        // 지역클래스는 접근제어자 사용불가
        class LocalPrinter {
            int value = 30;

            public void printData() {
                System.out.println("value = " + value);

                System.out.println("localVar = " + localVar);
                System.out.println("paramVar = " + paramVar);

                System.out.println("outerInstanceVar = " + outerInstanceVar);
            }
        }

        LocalPrinter localPrinter = new LocalPrinter();
        localPrinter.printData();
    }

    public static void main(String[] args) {
        LocalOuter outer = new LocalOuter();
        outer.process(0);
    }
}
