package ch07annotation.step5validator.after;

import java.lang.reflect.Field;

// 검증용 애노테이션을 활요한 검증 클래스
// 어떤 객체든지 애노테이션으로 간단하게 검증할 수 있게되었음
public class Validator {

    // Team, User
    public static void validate (Object object) throws Exception { //예제여서 예외 던짐

        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);

            if(field.isAnnotationPresent(NotEmpty.class)){
                String value = (String) field.get(object);
                NotEmpty annotation = field.getAnnotation(NotEmpty.class);

                if (value == null || value.isEmpty()) {
                    throw new RuntimeException(annotation.message());
                }
            }

            if(field.isAnnotationPresent(Range.class)){
                int value = (int) field.get(object);
                Range range = field.getAnnotation(Range.class);

                if (value < range.min() || value > range.max()) {
                    throw new RuntimeException(range.message());
                }
            }
        }
    }
}
