package ch21lang.section4class;

import java.lang.reflect.InvocationTargetException;

public class ClassCreateMain {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        //Class<?> aClass = Class.forName("ch21lang.section4class.Hello");
        Class<Hello> helloClass = Hello.class;

        // 객체 생성
        Hello hello = helloClass.getDeclaredConstructor().newInstance();
        String helloResult = hello.hello();

        System.out.println("hello = " + hello);
        System.out.println("helloResult = " + helloResult);
    }
}
