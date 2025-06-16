package ch20polymorphism.section1basic.sub2casting.step2instanceof;

import ch20polymorphism.section1basic.sub1.Child;
import ch20polymorphism.section1basic.sub1.Parent;

public class InstanceofMain {
    public static void main(String[] args) {

        Parent parent1 = new Parent();
        System.out.println("=== parent1 === ");
        callChildMethod1(parent1);

        Parent parent2 = new Child();
        System.out.println("\n=== parent2 === ");
        callChildMethod1(parent2);
    }

    private static void callChildMethod1(Parent parent) {

        if (parent instanceof Child) { // Child 인스턴스인 경우
            System.out.println("Child 인스턴스(o)");
            ((Child) parent).childMethod();
        } else {
            System.out.println("Child 인스턴스(x)");
        }
    }

    // instanceof 패턴매칭방식 (java16 +)
    private static void callChildMethod2(Parent parent) {

        if (parent instanceof Child child) { // 타입이 맞으면 Child 타입으로 변수선언
            System.out.println("Child 인스턴스(o)");
            child.childMethod();
        } else {
            System.out.println("Child 인스턴스(x)");
        }
    }


}
