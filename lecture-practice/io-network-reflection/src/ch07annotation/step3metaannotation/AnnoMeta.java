package ch07annotation.step3metaannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface AnnoMeta {
}

/*
- @Retention 애노테이션의 생존 기간을 지정
    -  RetentionPolicy.RUNTIME
    -  RetentionPolicy.CLASS
    -  RetentionPolicy.SOURCE

- @Target 애노테이션을 적용할 수 있는 위치 지정
    - ElementType.TYPE
    - ElementType.METHOD
    - ElementType.FIELD
    - ElementType.PARAMETER
    - ElementType.CONSTRUCTOR
    ..... 등
    
- @Documented 자바 API 문서를 만들 때 해당 애노테이션이 함께 포함되는지 지정

- @Inherited
    애노테이션 정의 시 @Inherited 를 붙이면,
    애노테이션을 적용한 클래스의 자식도 해당 애노테이션 부여받을 수 있음
    클래스 상속에서만 작동, 인터페이스 구현체에는 적용 x
*/