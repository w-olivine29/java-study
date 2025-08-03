package ch04applylambda.sub4stream.step1;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStreamV1 {

    // 스트림은 자신의 데이터 리스트를 가짐
    private List<Integer> internalList;

    public MyStreamV1(List<Integer> internalList) {
        this.internalList = internalList;
    }

    public MyStreamV1 filter(Predicate<Integer> predicate) {

        List<Integer> filtered = new ArrayList<>();
        for (Integer element : internalList) {
            if (predicate.test(element)) {
                filtered.add(element);
            }
        }
        return new MyStreamV1(filtered);
    }

    public MyStreamV1 map(Function<Integer, Integer> mapper) {
        List<Integer> mapped = new ArrayList<>();
        for (Integer element : internalList) {
            mapped.add(mapper.apply(element));
        }
        return new MyStreamV1(mapped);
    }

    public List<Integer> toList(){
        return this.internalList;
    }
}
