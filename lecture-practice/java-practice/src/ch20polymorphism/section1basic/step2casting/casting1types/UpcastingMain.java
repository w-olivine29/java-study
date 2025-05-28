package ch20polymorphism.section1basic.step2casting.casting1types;

import ch20polymorphism.section1basic.step1.Child;
import ch20polymorphism.section1basic.step1.Parent;

public class UpcastingMain {
    public static void main(String[] args) {

        // 다른 타입에 들어갈 때는 무조건 타입변환이 필요
        // 업캐스팅은 생략 가능 (컴파일러가 업캐스팅해줌)
        Child child = new Child();
        Parent parent1 = (Parent) child; // 생략 권장
        Parent parent2 = child;

        parent1.parentMethod();
        parent2.parentMethod();

    }
}
