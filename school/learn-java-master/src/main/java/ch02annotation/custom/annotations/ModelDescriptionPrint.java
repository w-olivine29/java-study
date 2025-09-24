package ch02annotation.custom.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ModelDescriptionPrints.class) // 해당 애노테이션을 여러개 중복적으로 사용하게 설정
public @interface ModelDescriptionPrint {

    String model();
    String description();

}
