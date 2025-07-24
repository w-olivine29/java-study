package ch06reflection.step4constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ConstructV2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("ch06reflection.data.BasicData");

        Constructor<?> constructor = aClass.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);

        // 동적으로 인스턴스 생성
        Object instance = constructor.newInstance("hello");
        System.out.println("instance = " + instance); //ch06reflection.data.BasicData@7291c18f
        
        // 메서드도 동적으로 호출
        Method declaredMethod = aClass.getDeclaredMethod("call");
        declaredMethod.invoke(instance);
    }
}
