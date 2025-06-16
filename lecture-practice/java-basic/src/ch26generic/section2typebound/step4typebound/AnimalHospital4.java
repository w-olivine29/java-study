package ch26generic.section2typebound.step4typebound;

import ch26generic.section2typebound.Animal;

/*
  타입 매개변수에 제한을 두어, Animal 또는 그 하위 클래스만 받을 수 있도록 설정
  - 최소한 Animal 타입은 보장되므로, Animal의 메서드들을 안전하게 사용가능
  - 해당 클래스에서는 T를 Animal로 간주하고 기능 활용 가능
*/
public class AnimalHospital4<T extends Animal> {

    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public T get() {
        return animal;
    }


    // Animal 기능 사용가능
    public void checkup() {
        System.out.println("name: " + animal.getName());
        System.out.println("weight: " + animal.getWeight());
    }

    public T heavierThan(T target) {
        return animal.getWeight() > target.getWeight() ? animal : target;
    }
}
