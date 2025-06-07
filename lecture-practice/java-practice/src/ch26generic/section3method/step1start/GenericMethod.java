package ch26generic.section3method.step1start;

public class GenericMethod {

    public static Object objMethod(Object obj) {
        System.out.println("Object print = " + obj);
        return obj;
    }

    // 제네릭 메서드 정의: 반환 타입 앞에 <T>를 선언하여 메서드에 제네릭 타입을 적용 (해당 메서드에서만 한정적 사용)
    public static <T> T genericMethod(T t) {
        System.out.println("Object print = " + t);
        return t;
    }

    public static <T extends Number> T numberMethod(T t) {
        System.out.println("Object print = " + t);
        return t;
    }

    /*
      클래스에 정의된 제네릭 타입은 static 메서드에서 사용할 수 없음.
      → 클래스의 제네릭 타입은 인스턴스 생성 시점에 결정되지만,
         static 메서드는 클래스 수준에서 동작하므로 인스턴스 정보에 접근할 수 없음.

      따라서 static 메서드에서 제네릭을 사용하려면,
      메서드 자체에 제네릭 타입을 선언한 '제네릭 메서드'로 정의해야 함.
     */

}
