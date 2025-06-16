package ch26generic.section1necessity.step3generic;

public class RawTypMain {
    public static void main(String[] args) {
        GenericBox integerBox = new GenericBox(); // 제네릭 정보를 넣지 않는다면?
        //GenericBox<Object> integerBox = new GenericBox<>(); // 권장



        /*
        RowType(원시타입):
            - <> 를 지정하지 않는 경우
            - 내부 타입이 Object로 사용된다고 이해
            - 제네릭이 없는 과거 버전과의 하위호환 때문에 지원중

        Object 타입을 사용해야한다면, 직접 <Object> 사용 권장
        */
    }
}
