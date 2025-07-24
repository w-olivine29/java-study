package ch06reflection.step2method;

import ch06reflection.data.BasicData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Method2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        
        // 정적 메서드 호출 (일반적인 방식의 메서드 호출)
        // 호출하는 메서드가 이미 코드로 작성돼서 정적으로 변경할 수 없는 상태
        BasicData instance = new BasicData();
        instance.call(); // 이 부분은 직접 코드를 변경하지 않는 이상 다른 메서드로 변경 불가

        // 동적 메서드 호출 - 리플렉션 사용
        Class<? extends BasicData> helloClass = instance.getClass();
        String methodName = "hello";
        
        // 메서드 이름을 변수로 변경할 수 있음
        Method method1 = helloClass.getDeclaredMethod(methodName, String.class); //getDeclaredMethod(String name, Class<?>... parameterTypes)
        Object returnValue = method1.invoke(instance, "hi");// 메서드 호출 시 어떤 인스턴스에 있는 메서드를 호출할것인지, 인자값 넣어주기
        System.out.println("returnValue = " + returnValue);
    }
}
