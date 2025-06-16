package ch19inheritance.after.step5super.construct;

// 상속관계 사용시, 자식 클래스의 생성자에서 부모 클래스의 생성자를 반드시 호출해야한다.
public class ClassA {


    public ClassA() {
        System.out.println("ClassA()");
    }
}
