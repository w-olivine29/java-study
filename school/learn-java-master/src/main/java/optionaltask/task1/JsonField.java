package optionaltask.task1;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

// 41기 유도경
@Retention(RetentionPolicy.RUNTIME)
@Target(FIELD)
public @interface JsonField {

    String value() default ""; //직접 지정하지 않으면 JsonSerializer 에서 직접 변환하게끔 구현

    boolean skipYn() default false;
}
