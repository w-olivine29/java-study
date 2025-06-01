package ch21lang.section4class;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassMetaMain {
    public static void main(String[] args) throws ClassNotFoundException {
        // Class 조회
        Class<String> stringClass = String.class; //1.클래스에서 조회
        Class<? extends String> aClass = new String().getClass(); //2.인스턴스에서 조회
        Class<?> aClass1 = Class.forName("java.lang.String"); //3.문자열로 조회 (ClassNotFoundException 발생 가능성)

        // 모든 필드 출력
        Field[] fields = stringClass.getDeclaredFields();
        System.out.println("\n===== getDeclaredFields() =======================");
        for (Field field : fields) {
            System.out.printf("field:[%s] \n  type: %s, name: %s\n",
                    field, field.getType(), field.getName());
        }

        // public 필드만 출력
        Field[] publicFields = stringClass.getFields();
        System.out.println("\n===== getFields() =========================");
        for (Field field : publicFields) {
            System.out.printf("field:[%s] \n  type: %s, name: %s\n",
                    field, field.getType(), field.getName());
        }

        // 모든 메서드 출력
        Method[] methods = stringClass.getDeclaredMethods();
        System.out.println("\n===== getDeclaredMethods() =========================");
        for (Method method : methods) {
            System.out.printf("method:[%s] \n  returnType: %s, name: %s\n",
                    method, method.getReturnType(), method.getName());
        }

        // public 메서드만 출력
        Method[]  publicMethods = stringClass.getMethods();
        System.out.println("\n===== getMethods() =========================");
        for (Method method : publicMethods) {
            System.out.printf("method:[%s] \n  returnType: %s, name: %s\n",
                    method, method.getReturnType(), method.getName());
        }

        // 상위 클래스 정보 출력
        Class<? super String> superclass = stringClass.getSuperclass();
        System.out.println("\nSuperClass of String: " + superclass); //Object
        System.out.println("\nSuperClass of SuperClass: " + superclass.getSuperclass()); //null (Object가 최상위 클래스)

        // 인터페이스 정보 출력
        Class<?>[] interfaces = stringClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.printf("interface:[%s]\n  name: %s\n",
                    anInterface, anInterface.getName());
        }
    }
}
