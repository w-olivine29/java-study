package ch26generic.section3method.step3priority;

import ch26generic.section3method.Animal;

public class ComplexBox<T extends Animal> {

    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }


    // Type parameter 'T' hides type parameter 'T'
    public <T> T printAndReturn(T t) {
        System.out.println("animal.className = " + animal.getClass().getName());
        System.out.println("method p className = " + t.getClass().getName());
        return t;
    }

    /*
      제네릭타입(클래스)과 제네릭메서드의 이름이 T로 동일한 상황 -> 그럼 T의 타입은 무엇인가?
      이 경우 제네릭메서드 내에서는 제네릭타입(클래스) 보다 제네릭 메서드가 높은 우선순위를 가짐
      우선순위 덕분에 이름이 동일해도 오류가 발생하진 않지만 바꾸는 것을 지향

      Type parameter 'T' hides type parameter 'T'
    */


}
