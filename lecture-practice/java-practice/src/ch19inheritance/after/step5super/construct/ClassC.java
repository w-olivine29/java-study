package ch19inheritance.after.step5super.construct;

// ClassB는 기본생성자가 없는 상태(자동생성x, 명시x)
public class ClassC extends ClassB {


    // 상위 클래스에 기본생성자가 없다면, super의 생성자를 반드시 직접 호출해야한다.
    // 여러 개면 하나를 선택해서 호출하면 된다.
    public ClassC() {
        super(1,2);
        System.out.println("ClassC()");
    }

    public ClassC(int a) {
        super(1,3);
    }


    public ClassC(int a, int b) {
        this(1); // 해당 생성자 내부에서 결국 super 를 호출
    }

    
    // 생성자는 한번만 호출 가능
    public ClassC(int a, int b, int c) {
        this(1); 
        //super(1,2); //Only one explicit constructor call allowed in constructor
    }

}
