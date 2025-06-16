package ch21lang.section1obejct.sub1start;

// 부모가 없으면 자동으로 묵시적 상속 -> Object 클래스
public class Parent extends Object { // explicitly extends 'java.lang.Object' (생략권장)
    public void parentMethod() {
        System.out.println("Parent.parentMethod");
    }
}
