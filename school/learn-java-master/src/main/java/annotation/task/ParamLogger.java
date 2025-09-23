package annotation.task;

/* 메서드 호출 시 매개변수를 기록하는 Annotation 만들기
- 매개변수가 출력 되었는가?
- 매개변수가 n개일 때도 작동하는가?
*/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ParamLogger {


}
