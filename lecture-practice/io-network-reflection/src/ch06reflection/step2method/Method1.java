package ch06reflection.step2method;

import ch06reflection.data.BasicData;

import java.lang.reflect.Method;

public class Method1 {
    public static void main(String[] args) {
        Class<BasicData> helloClass = BasicData.class;


        System.out.println("===== methods() =====");
        Method[] methods = helloClass.getMethods(); // public 메서드만 가져옴
        for (Method method : methods) {
            System.out.println("method = " + method);
        }

        System.out.println("===== declaredMethods() =====");
        Method[] declaredMethods = helloClass.getDeclaredMethods(); // 클래스에 선언한 모든 메서드 (상속메서드 제외)
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod = " + declaredMethod);
        }
    }
}
