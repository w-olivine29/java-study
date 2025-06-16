package ch24nestedclasses.example.ex4;

// 익명클래스 완성하기
// hello() 호출
public class OuterClassMain {
    public static void main(String[] args) {
        Hello hello = new Hello(){
            @Override
            public void hello() {
                System.out.println("OuterClassMain.hello");
            }
        };

        hello.hello();
    }
}
