package ch20polymorphism.section2.sub2interface.step2multi;

public class MultiImplementMain {
    public static void main(String[] args) {

        InterfaceA a = new Child();
        a.methodA();
        a.methodCommon();

        InterfaceB b = new Child();
        b.methodB();
        b.methodCommon();
    }
}
