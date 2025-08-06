package ch04applylambda.sub4stream.step3generic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

// 제네릭 추가
public class MyStreamV3<T> {

    // 스트림은 자신의 데이터 리스트를 가짐
    private List<T> internalList;

    // 외부에서 생성자 호출 못하게 방지
    private MyStreamV3(List<T> internalList) {
        this.internalList = internalList;
    }

    // 정적 팩토리
    // 제너릭 메서드 타입으로 제너릭 타입이 정해질 것임
    public static <T> MyStreamV3<T> of(List<T> integerList) {
        return new MyStreamV3<>(integerList);
    }

    public MyStreamV3<T> filter(Predicate<T> predicate) {

        List<T> filtered = new ArrayList<>();
        for (T element : internalList) {
            if (predicate.test(element)) {
                filtered.add(element);
            }
        }
        return MyStreamV3.of(filtered);
    }

    // T는 제너릭 타입에서 정의한 타입
    // R은 제너릭 메서드에서 정의한 타입
    public <R> MyStreamV3<R> map(Function<T, R> mapper) {
        List<R> mapped = new ArrayList<>();
        for (T element : internalList) {
            mapped.add(mapper.apply(element));
        }
        return MyStreamV3.of(mapped);
    }

    public List<T> toList() {
        return this.internalList;
    }

    public T getFirst(){
        return internalList.getFirst();
    }
}
