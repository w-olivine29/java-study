package ch21lang.section1obejct.sub1start;


//Object <- Parent <- Child
public class Child extends Parent { // 명시적 상속시 Object 상속 x (다중상속이 불가)

    public void childMethod() {
        System.out.println("Child.childMethod");
    }
}
