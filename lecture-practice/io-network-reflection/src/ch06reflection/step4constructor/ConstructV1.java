package ch06reflection.step4constructor;

import java.lang.reflect.Constructor;

public class ConstructV1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("ch06reflection.data.BasicData");

        System.out.println("===== getConstructors() =====");
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("constructor = " + constructor); //public ch06reflection.data.BasicData()
        }


        System.out.println("===== getDeclaredConstructors() =====");
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors(); // 모든 생성자
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println("constructor = " + constructor);

//            constructor = public ch06reflection.data.BasicData()
//            constructor = private ch06reflection.data.BasicData(java.lang.String)
        }
    }
}
