package ch04applylambda.sub4stream.step2staticfactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

// 정적 팩토리 메서드 추가
public class MyStreamV2 {

    // 스트림은 자신의 데이터 리스트를 가짐
    private List<Integer> internalList;

    // 외부에서 생성자 호출 못하게 방지
    private MyStreamV2(List<Integer> internalList) {
        this.internalList = internalList;
    }
    
    // 정적 팩토리
    public static MyStreamV2 of(List<Integer> integerList){
        return new MyStreamV2(integerList);
    }

    public MyStreamV2 filter(Predicate<Integer> predicate) {

        List<Integer> filtered = new ArrayList<>();
        for (Integer element : internalList) {
            if (predicate.test(element)) {
                filtered.add(element);
            }
        }
        return new MyStreamV2(filtered);
    }

    public MyStreamV2 map(Function<Integer, Integer> mapper) {
        List<Integer> mapped = new ArrayList<>();
        for (Integer element : internalList) {
            mapped.add(mapper.apply(element));
        }
        return new MyStreamV2(mapped);
    }

    public List<Integer> toList(){
        return this.internalList;
    }
}
