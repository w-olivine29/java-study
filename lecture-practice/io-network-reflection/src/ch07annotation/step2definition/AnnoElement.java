package ch07annotation.step2definition;

import utils.MyLogger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnnoElement {

    String value();
    int count() default 0;
    String[] tags() default {};

    Class<? extends MyLogger> data() default MyLogger.class;
}

/* 애노테이션 정의 규칙

- 데이터타입
    - 기본타입
    - String
    - Class(메타데이터) or 인터페이스
    - enum
    - 다른 애노테이션 타입
    - 위 타입들의 배열

    이 외 타입은 정의 불가

- 요소에 default 값 지정가능

- 반환 값으로 void 사용 불가

- 예외 선언 불가

- value 라는 이름의 요소 하나만 가질 경우 
    애노테이션 사용 시 요소 이름 생략 가능

*/