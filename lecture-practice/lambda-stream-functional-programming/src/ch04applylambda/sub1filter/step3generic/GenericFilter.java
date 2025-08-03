package ch04applylambda.sub1filter.step3generic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GenericFilter {

    // 클래스 레벨 제네릭이 아닌 메서드 레벨 제네릭으로 구현해야 함
    // static 메서드는 클래스 레벨 제네릭 타입 매개변수에 접근할 수 없음
    // 클래스 레벨 제네릭은 인스턴스 생성 시 타입이 결정되지만,
    //  static은 인스턴스 생성 없이 클래스 로딩 시점에 사용 가능해야 함
    public static <T>List<T> filter(List<T> numbers, Predicate<T> predicate){
        List<T> result = new ArrayList<>();
        for (T num : numbers) {
            if (predicate.test(num)) {
                result.add(num);
            }
        }
        return result;
    }
}
