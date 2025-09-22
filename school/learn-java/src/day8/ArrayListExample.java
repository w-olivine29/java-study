package day8;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        System.out.println("list.size() = " + list.size());
        System.out.println(list); // Collection 하위 클래스들은 toString 재정의 -> 참조 값 출력 시 요소 출력

        System.out.println("===== 중간에 데이터 추가 =====");
        list.add(0,500); //addFirst() 와 동일
        list.add(2,1000);
        System.out.println(list); //[500, 1, 1000, 1, 1, 1, 1]

        System.out.println("===== 컬렉션 추가 =====");
        list.addAll(List.of(5,5,5,5,5,5,5)); // 마지막 요소 뒤에 순차적으로 저장
        System.out.println(list);  //[500, 1, 1000, 1, 1, 1, 1] -> [500, 1, 1000, 1, 1, 1, 1, 5, 5, 5, 5, 5, 5, 5]

        list.addAll(0, List.of(9,9,9,9)); // 특정 위치에 순차적으로 저장
        System.out.println(list); //[9, 9, 9, 9, 500, 1, 1000, 1, 1, 1, 1, 5, 5, 5, 5, 5, 5, 5]

        System.out.println();

        // remove는 바뀌기 전의 값을 반환
        System.out.println("===== 인덱스 기반 삭제 =====");
        System.out.println("0번 인덱스 요소 삭제: " + list.remove(0)); // removeFirst() 와 동일
        System.out.println("마지막 인덱스 요소 삭제: " + list.remove(list.size() - 1)); // removeLast() 와 동일
        System.out.println("list.size() = " + list.size());
        System.out.println(list);

        System.out.println("===== 값 기반 삭제 =====");

        // int(기본타입)을 넣으면 인자를 인덱스로 인식해버리기 때문에 Wrapper 타입으로 넣기
        list.remove(Integer.valueOf(1)); // 해당 값을 가진 첫번째 요소만 삭제
        System.out.println(list); //[9, 9, 9, 500, 1, 1000, 1, 1, 1, 1, 5, 5, 5, 5, 5, 5] -> [9, 9, 9, 500, 1000, 1, 1, 1, 1, 5, 5, 5, 5, 5, 5]

        // removeAll - 해당 값에 속하는 첫번째 요소만이 아닌 모든 요소 삭제
        System.out.println("list.removeAll(List.of(9, 500, 5)) = " + list.removeAll(List.of(9, 500, 5)));
        System.out.println(list); //[1000, 1, 1, 1, 1]

        
        // 반복문 출력
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d번 인덱스 요소: %d\n", i, list.get(i));
        }

        //set은 바뀌기 전의 값을 반환
        System.out.printf("\n0번 인덱스 요소 수정 %d -> %d\n", list.set(0, 100), list.getFirst());

        System.out.println();
        for (Integer integer : list) {
            System.out.println("list.get(i) = " + integer);
        }

        // retain
        System.out.println("list.retainAll(List.of(1)) = " + list.retainAll(List.of(1))); // 해당 요소만 남기고 삭제
        System.out.println(list);  //[100, 1, 1, 1, 1] -> [1, 1, 1, 1]


        System.out.println("list clear");
        list.clear();
        System.out.println(list); //[]
    }
}
