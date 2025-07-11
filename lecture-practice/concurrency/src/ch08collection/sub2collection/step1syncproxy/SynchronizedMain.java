package ch08collection.sub2collection.step1syncproxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("data1");
        list.add("data2");
        list.add("data3");
        System.out.println(list.getClass());
        System.out.println("list = " + list);

        System.out.println();

        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
        syncList.add("data1");
        syncList.add("data2");
        syncList.add("data3");
        System.out.println(syncList.getClass()); //class java.util.Collections$SynchronizedRandomAccessList
        System.out.println("syncList = " + syncList);

    }
}

/*
class java.util.ArrayList
list = [data1, data2, data3]

class java.util.Collections$SynchronizedRandomAccessList
syncList = [data1, data2, data3]


SynchronizedRandomAccessList
- synchronized 를 추가하는 프록시 역할
- 클라이언트 -> ArrayList
- 클라이언트 -> SynchronizedRandomAccessList -> ArrayList
(ArrayList, SynchronizedRandomAccessList -> List 구현)

Synchronized 프록시 방식의 단점
- 동기화 오버헤드
    모든 메서드 호출 시 비용 발생 -> 성능 저하

- 전체 컬렉션 동기화(넓은 잠금 범위)
    잠금 경합 증가, 병렬 처리 효율성 저하
    특정 스레드가 컬렉션 사용 시 다른 스레드들 대기하는 상황 빈번

- 정교한 동기화 불가
    선택적 동기화 어려움

결론)
단순무식하게 모든 메서드에 synchronized를 적용하는 방식
최적화되지 않은 동기화
이를 보완하기 위해 java.util.concurrent 패키지의 동시성 컬렉션 제공
*/