package ch19inheritance.after.step5super.construct;

public class ClassB extends ClassA {

    public ClassB(int a) {
        //super(); // super의 기본 생성자는 생략 가능 (자동으로 가장 첫줄에 넣어줌)
        System.out.println("ClassB(int a) 호출");
    }

    public ClassB(int a, int b) {
        //super();  // super의 기본 생성자는 생략 가능 (자동으로 가장 첫줄에 넣어줌)
        System.out.println("ClassB(int a, int b) 호출");
    }

}
