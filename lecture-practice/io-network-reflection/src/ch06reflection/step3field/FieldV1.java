package ch06reflection.step3field;

import ch06reflection.data.BasicData;

import java.lang.reflect.Field;

public class FieldV1 {
    public static void main(String[] args) {
        Class<BasicData> basicDataClass = BasicData.class;

        System.out.println("====== getFields() =====");
        Field[] fields = basicDataClass.getFields(); // public 필드만
        for (Field field : fields) {
            System.out.println("field = " + field); // 패키지 경로까지 포함
            System.out.println("field.getName() = " + field.getName());
        }

        System.out.println("====== getDeclaredFields() =====");
        Field[] declaredFields = basicDataClass.getDeclaredFields(); // 모든 필드(상속 제외)
        for (Field field : declaredFields) {
            System.out.println("field = " + field); // 패키지 경로까지 포함
            System.out.println("field.getName() = " + field.getName());
        }

    }
}
