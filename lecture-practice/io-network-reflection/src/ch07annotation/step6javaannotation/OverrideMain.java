package ch07annotation.step6javaannotation;

public class OverrideMain {

    static class A {
        public void call() {
            System.out.println("OverrideMain.call");

        }
    }
    static class B extends A {

        //메서드가 실제로 부모 클래스나 인터페이스의 메서드를 올바르게 오버라이드하고 있는지 검증
        @Override
        public void call(){
            System.out.println("B.call");
        }
    }

    public static void main(String[] args) {
        A a = new B();
        a.call();
    }
}

/*
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Override {
}
*/
