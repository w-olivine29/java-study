package ch20polymorphism.section1basic.sub2casting.step1types;

import ch20polymorphism.section1basic.sub1.Child;
import ch20polymorphism.section1basic.sub1.Parent;

public class DownCastingMain {
    public static void main(String[] args) {

        Parent poly = new Child();
        //poly.childMethod(); 자식기능은 호출 불가

        //다운캐스팅 (부모타입 -> 자식타입)
        Child child = (Child) poly;
        child.parentMethod();
        child.childMethod();

        /*
        poly의 타입이 변하는 것이 아닌 poly의 참조값을 "복사"하고 복사본을 Child 타입 변수에 새로 대입 (poly의 타입은 Parent로 기존과 같이 유지된다)
        자바에서 대입연산 시 기존 것을 건드리지 않는다. (기존 것을 복사작업한다.)
        */

        // 일시적 다운캐스팅 (해당 메서드르 호출하는 순간만 다운캐스팅)
        ((Child) poly).childMethod(); // 이것도 poly "복사본"을 다운캐스팅하는 것

    }
}

