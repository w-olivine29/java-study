package ch07annotation.step1start;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SimpleMapping {
    String value();
}


/* 애노테이션
Annotation: "주석" or "메모" 뜻함

애노테이션은 코드에 추가적인 정보를 주석처럼 제공
일반 주석과 달리 컴파일러나 런타임에서 해석될 수 있는 메타데이터 제공
코드에 메모를 달아놓은 것처럼 특정 정보나 지시를 추가하는 도구로써, 코드에 대한 메타데이터 표현

애노테이션이라는 이름은 코드에 대한 추가적인 정보를 주석처럼 달아놓는다는 뜻
*/