package ch07annotation.step4inherited;

import java.lang.annotation.Annotation;

public class InheritedMain {
    public static void main(String[] args) {
        print(Parent.class);
        print(Child.class); //InheritedAnnotation 만 나옴
        print(TestInterface.class);
        print(TestInterfaceImpl.class); // 없음
    }

    private static void print(Class<?> clazz) {
        System.out.println("clazz = " + clazz);

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(" - " + annotation.annotationType().getSimpleName());
        }
        System.out.println();
    }
}

/* @Inherited
애노테이션 정의 시 @Inherited 를 붙이면,
애노테이션을 적용한 클래스의 자식도 해당 애노테이션 부여받을 수 있음
클래스 상속에서만 작동, 인터페이스 구현체에는 적용 x
*/
