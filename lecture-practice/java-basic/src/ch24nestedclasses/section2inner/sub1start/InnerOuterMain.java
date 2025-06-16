package ch24nestedclasses.section2inner.sub1start;

public class InnerOuterMain {
    public static void main(String[] args) {
        InnerOuter innerOuter = new InnerOuter();
        InnerOuter.Inner inner = innerOuter.new Inner();
        inner.print();

        System.out.println("innerClass = " + inner.getClass()); //패키지경로.InnerOuter$Inner



        /*
         내부클래스 생성 시 바깥 클래스의 인스턴스 참조 필요 (인스턴스에 소속 됨)
         -> 바깥 클래스의 인스턴스는 여러개 생성이 가능
         -> 어떤 인스턴스를 참조할 것인지 정해줘야함
        */
        InnerOuter.Inner inner1 = new InnerOuter().new Inner();
        InnerOuter.Inner inner2 = new InnerOuter().new Inner();

    }
}
