package ch19inheritance.after.step5super.reference;

public class Child extends Parent {

    public String value = "child";

    @Override
    public void hello() {
        System.out.println("Child.hello");
    }

    // super: 부모클래스에 대한 참조
    // 이름중복 필드 or 오버라이딩 메서드의 경우 super를 통해 부모클래스 접근해서 사용 가능
    public void callFamily() {
        System.out.println("this value = " + value); //this
        System.out.println("super.value = " + super.value); //부모

        hello(); //this
        super.hello();
    }
}
