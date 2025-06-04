package ch24nestedclasses.section3local.sub2anonymous.step1start;

public class AnonymousOuter {

    private int outInstanceVar = 10;

    public void process(int paramVar) {
        int localVar = 20;

        Printer anonymousPrinter = new Printer() {
            int value = 30; //익명클래스도 클래스라서 변수 선언 가능

            @Override
            public void print() {
                System.out.println("멤버변수(localInner): " + value);
                System.out.println("지역변수: " + localVar);
                System.out.println("매개변수: " + paramVar);
                System.out.println("멤버변수(outer): " + AnonymousOuter.this.outInstanceVar);
            }
        };
    /*
        클래스 body를 정의하면서 생성
        인터페이스나 추상클래스를 구현하면서 "구현체를 이름없이" 만드는 것 (익명클래스는 상위클래스나 인터페이스 필요)
        상속받으면서 정의&구현 동시진행

        인터페이스 이름 앞에 new 가 붙어서 있어서 착각할 수 있는데
        Printer 객체를 생성하는 것이 아님 (Printer 인터페이스를 구현한 익명 클래스를 생성)

        지역클래스가 일회성 사용되거나 간단한 구현 시 사용
    * */

        anonymousPrinter.print();

        System.out.println("anonymousPrinter class:  " + anonymousPrinter.getClass());
        // class 패키지경로.AnonymousOuter$1 (익명클래스는 숫자로 정의된다, 여러개일 경우 숫자 증가)
    }

    public static void main(String[] args) {
        AnonymousOuter anonymousOuter = new AnonymousOuter();
        anonymousOuter.process(2);

    }
}
