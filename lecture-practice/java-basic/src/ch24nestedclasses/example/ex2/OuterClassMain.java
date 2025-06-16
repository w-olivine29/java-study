package ch24nestedclasses.example.ex2;

// 중첩클래스(내부 클래스) & hello() 메서드 구현
// hello() 호출
public class OuterClassMain {
    public static void main(String[] args) {
        OuterClass.NestedClass nestedClass = new OuterClass().new NestedClass();
        nestedClass.hello();
    }
}
