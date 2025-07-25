package ch07annotation.step1start;

import java.lang.reflect.Method;

public class TestControllerMain {
    public static void main(String[] args) {
        TestController testController = new TestController();

        Class<? extends TestController> aClass = testController.getClass();
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("TestControllerMain.main");

            // 해당 메서드에 붙어있는 특정 애노테이션을 찾을 수 있음
            SimpleMapping annotation = method.getAnnotation(SimpleMapping.class);
            if (annotation != null) {
                System.out.println(String.format("[%s] -> %s", annotation.value(), method.getName()));
            }
        }
    }
}
