package ch26generic.section2typebound.step3failedgeneric;

public class AnimalHospital3<T> {

    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public T get() {
        return animal;
    }



    // 메서드 정의 시점에는 T의 타입을 알 수 없음 (Object 기능만 사용가능)
//    public void checkup() {
//        System.out.println("name: " + animal.getName());
//        System.out.println("weight: " + animal.getWeight());
//    }

//    public T heavierThan(Animal target) {
//        return animal.getWeight() > target.getWeight() ? animal : target;
//    }
}
