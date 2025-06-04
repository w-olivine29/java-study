package ch24nestedclasses.section1static.sub1start;

public class NestedMain {
    public static void main(String[] args) {
        NestedOuter outer = new NestedOuter();
        NestedOuter.Nested nested = new NestedOuter.Nested(); //static 이니까 outer 인스턴스와는 상관없이 바로 생성가능
        nested.print();

        System.out.println("nestedClass = " + nested.getClass()); //패키지경로.NestedOuter$Nested
    }
}
