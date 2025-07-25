package ch07annotation.step6javaannotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SuppressWarningCase {

    @SuppressWarnings("unused")
    public void unusedWarning(){
        // 사용되지 않는 변수 경고 억제
        int unusedNum = 10;
    }

    @SuppressWarnings("deprecation")
    public void deprecatedMethod(){
        Date date = new Date();
        int date1 = date.getDate(); //'getDate()' is deprecated (애노테이션 제거시 해당 문구 발생)
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void uncheckedCast() {
        // 제네릭 타입 캐스팅 경고 억제 (raw type 사용 경고)
        List list = new ArrayList<>(); //Raw use of parameterized class 'ArrayList'

        // 제네릭 타입 관련 경고
        List<String> strList = (List<String>)list; //Unchecked cast: 'java.util.List' to 'java.util.List<java.lang.String>'
    }

    @SuppressWarnings("all")
    public void suppressAllWaring() {
        Date date = new Date();
        int date1 = date.getDate();
        List list = new ArrayList<>();
        List<String> strList = (List<String>)list;
    }
}

/* @SuppressWarnings

- all 
    모든 경고 역제
- deprecation
    사용권장되지 않는 코드 사용 시 발생하는 경고 억제
- unchecked
    제네릭 타입과 관련된 unchecked 경고 억제
- serial
    Serializable 인터페이스 구현 시 serialVersionUID 필드를 선언하지 않은 경우 발생하는 경고 억제
- rawtypes
    제네릭 타입이 명시되지 않은 raw 타입 사용 시 발생하는 경고 억제
- unused
    사용되지 않는 변수, 메서드, 필드 등을 선언 시에 발생하는 경고 억제
*/

