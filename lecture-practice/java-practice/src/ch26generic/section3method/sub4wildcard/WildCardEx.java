package ch26generic.section3method.sub4wildcard;


import ch26generic.section3method.Animal;

public class WildCardEx {

    static <T> void printGenericV1(Box<T> box) {
        System.out.println("T = " + box.get());
    }

    static void printWildCardV1(Box<?> box) {
        System.out.println("? = " + box.get());
    }


    static <T extends Animal> void printGenericV2(Box<T> box) {
        T t = box.get();
        System.out.println("t 이름 = " + t.getName()); // Animal의 getName()
    }

    static void printWildCardV2(Box<? extends Animal> box) {
        Animal animal = box.get();
        System.out.println("t 이름 = " + animal.getName());
    }


    static <T extends Animal> T printAndReturn(Box<T> box) {
        T t = box.get();
        System.out.println("t 이름 = " + t.getName());

        return t;
    }

    static Animal printAndReturnWildcard(Box<? extends Animal> box) {
        Animal value = box.get();
        System.out.println("이름: " + value.getName());
        return value;
    }


    /*
     와일드카드는 제네릭 타입이나 제네릭 메서드 선언시에 사용 x
     이미 만들어진 제네릭 타입을 활용할 때 사용
     
     제네릭 타입이나 제네릭 메서드를 정의하는게 꼭 필요한 상황이 아닐 떈, 더 단순한 와일드카드 사용권장
     but
     타입매개변수가 꼭 필요한 경우는 제외
    */
}
