package ch07annotation.step5validator.after;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Range {

    int min();
    int max();
    String message() default "기준 범위를 벗어났습니다.";
}
