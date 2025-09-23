package annotation.task;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

import static annotation.task.PrimitiveWrapperUtil.wrap;

public class ParameterLogger {


    // 호출하려는 메서드의 인스턴스를 받아야 내부에서 호출 가능
    // methodName: 리플렉션으로 메서드를 찾기 위함
    // params는 메서드 호출 시에 인자값으로 넘기기 위함
    public static Object logParams(Object object, String methodName, Object... args) {

        try {
            Method method = getMethod(object, methodName, args);
            method.setAccessible(true);

            // 애노테이션이 붙어있는 메서드만 로그 남기기
            if (method.getAnnotation(ParamLogger.class) != null) {
                logMethodParameters(method, args);
            }
            return method.invoke(object, args);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException("해당 메서드를 찾을 수 없습니다." + methodName, e);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException("메서드 호출 실패" + methodName + e);
        }
    }


    private static void logMethodParameters(Method method, Object... args) {
        Class<?>[] parameterTypes = method.getParameterTypes();

        if (args == null || parameterTypes.length == 0) {
            System.out.printf("[method parameter log] %s - void\n", method.getName());
            return;
        }

        StringBuilder sb = new StringBuilder(String.format("[method parameter log] %s -  ", method.getName()));

        for (int i = 0; i < args.length; i++) {
            sb.append(String.format("%s: %s", parameterTypes[i].getSimpleName(), args[i]));

            if (i < args.length - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }

    
    /* 주어진 객체에서 메서드 이름과 인자가 일치하는 메서드 찾기
    *  getDeclaredMethods() 를 반복문을 통해 메서드를 찾는 이유
    *    getDeclaredMethod(String name, Class<?>... parameterTypes)는 정확한 타입 배열을 넘겨야하는데, 
    *    인자를 Object로 받아오기 때문에 그대로 매핑하기는 어려움이 있음 (기본형 <-> 래퍼타입, 다형성, null 문제 등)
    *    따라서 모든 메서드를 꺼내 매핑작업 후 직접 비교
    *   
    */
    private static Method getMethod(Object object, String methodName, Object... args) throws NoSuchMethodException {

        Method result = null;
        // 인자에 대한 타입을 안전하게 넘겨서 찾기 위함
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (validateMethod(method, methodName, args)) {
                result = method;
            }
        }

        return Optional.ofNullable(result)
                .orElseThrow(() -> new NoSuchMethodException(
                        String.format("메서드 호출 실패: %s(%s): 해당 메서드를 찾을 수 없습니다.", methodName, Arrays.toString(args))));
    }

    private static boolean validateMethod(Method method, String methodName, Object... args) {

        // 이름 검증
        if (!method.getName().equals(methodName)) {
            return false;
        }

        // 파라미터 검증
        return validateParams(method, args);
    }


    
    /*
    * 리플렉션으로 찾은 메서드와 호출에 사용할 인자의 타입과 순서가 일치하는지 검증
    *   - 개수 검증
    *   - 순서 * 타입 검증
    *     - 기본형 타입
    *        리플렉션에서 그대로 int.class, double.class.. 형태로 나옴
    *        실제 메서드 호출 인자는 Object로 받으면서 오토박싱 -> Integer, Double.class 래퍼 타입
    *        논리적으로는 같은 타입이지만 실제론 다른 타입이기때문에 서로 맞춰줘서 비교해야함
    *         -> 리플렉션에서 찾은 타입을 래핑 후 비교
    *     - 참조형 타입
    *        다형성으로 받는 것을 고려하여 isAssignableFrom 으로 검사
    */
    private static boolean validateParams(Method method, Object... args) {

        Class<?>[] parameterTypes = method.getParameterTypes();

        if (args == null) {
            return parameterTypes.length == 0;
        }

        // 파라미터 개수 검증
        if (method.getParameterCount() != args.length) { //위에서 null에 대한 검사는 했으니 NullPointer 문제 발생 x
            return false;
        }

        // 파라미터 타입 & 순서 검증 (같은 인덱스로 접근해서 같은 순서가 같은 타입이 맞는지 검사)
        for (int i = 0; i < args.length; i++) {

            // 파라미터 타입이 기본타입인 경우
            if (parameterTypes[i].isPrimitive()) {
                return Objects.equals(wrap(parameterTypes[i]), args[i].getClass());
            }

            // 다형성으로 넘긴 경우도 타입을 맞춘 후 비교 (받는 부모클래스 타입에서 호출해줘야함)
            if (!parameterTypes[i].isAssignableFrom(args[i].getClass())) {
                return false;
            }
        }

        return true;
    }

}
