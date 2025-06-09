package ch27collection.section3list.sub1abstract.step2injection;

import ch27collection.section3list.sub2performance.mylist.MyArrayList;

public class BatchProcessor_Bad {

    // 구체적인 구현체에 의존 중
    private final MyArrayList<Integer> list = new MyArrayList<>();



    public void logic(int size){   // 복잡한 로직이라 가정 (list 앞 부분에 데이터 추가 반복)
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) { // 반복문 전체 도는데 O(n)
            list.add(0,i); // 데이터 하나 추가할때마다 데이터 이동때문에 O(n)
        }
        long endTime = System.currentTimeMillis();
        System.out.println("size: " + size + " ,time: " + (endTime - startTime) + "ms");
    }

    /*
        arrayList 클래스에 직접 의존했던 상태이며, logic 메서드 내의 로직을 실행하기에 성능이 좋지못함.
        -> LinkedList 변경 고려
        -> 클라이언트 코드인 해당 클래스의 내부 코드를 직접 변경해야함 (OCP 원칙 위배)
    */
}
