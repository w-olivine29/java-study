package ch24nestedclasses.example.ex1;

// 중첩클래스(정적 중첩클래스) & hello() 메서드 구현
// hello() 호출
public class OuterClassMain {
    public static void main(String[] args) {
        OuterClass.NestedClass nestedClass = new OuterClass.NestedClass();
        nestedClass.hello();
    }
}
