package ch20polymorphism.section1basic.step2casting.casting2instanceof;

import ch20polymorphism.section1basic.step1.Child;
import ch20polymorphism.section1basic.step1.Parent;

public class DownCastingMain {
    public static void main(String[] args) {
        Parent parent1 = new Child();
        Child child1 = (Child) parent1;

        Parent parent2 = new Parent();
        Child child2 = (Child) parent2; // ClassCastException
        child2.childMethod();


        /* 다운캐스팅은 자동으로 해주지 않는 이유
         * 타입 안정성 보장 불가
         *   - 컴파일 시점에는 해당 타입이 정말 자식타입인지 확정불가 (컴파일러는 선언된 타입만 보고 판단)
         *   - 잘못된 다운캐스팅은 런타임오류 발생
         * -> 예외적이고 주의가 필요한 작업으로 직접 책임지는 명시적 캐스팅 필요
         *
         * 안전하게 다운캐스팅 하기 위해선 확인작업이 필요 -> instanceof
         * */
    }
}
