package ch27collection.section3list.sub2performance;

import ch27collection.section3list.sub2performance.mylist.MyArrayList;
import ch27collection.section3list.sub2performance.mylist.MyLinkedList;
import ch27collection.section3list.sub2performance.mylist.MyList;

/*
- 추가
   - addFirst()
   - addMid()
   - addLast()
- 조회
- 검색
*/
public class MyListPerformanceTest {
    public static void main(String[] args) {

        int size = 50_000;
        System.out.println("**************** 데이터 추가 ****************");
        System.out.println("\n==== MyArraylist 추가 ====");
        addFirst(new MyArrayList<>(), size); // 1188 ms  O(n+1) -> O(n)
        addMid(new MyArrayList<>(), size); // 696 ms  O(1+n) -> O(n)
        addLast(new MyArrayList<>(), size); // 1 ms  O(1+1) -> O(1)

        System.out.println("\n==== MyLinkedList 추가 ====");
        addFirst(new MyLinkedList<>(), size); // 2 ms  O(1+1) -> O(1)
        addMid(new MyLinkedList<>(), size); // 1128 ms  O(n+1) -> O(n)
        addLast(new MyLinkedList<>(), size); // 1949 ms  O(n+1) -> O(n)

// ======================================================================================

        // 조회 & 검색 데이터 세팅
        int loop = 10000;
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        addLast(myArrayList, size);

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        addFirst(myLinkedList, size);

        System.out.println("**************** 데이터 조회 ****************");

        System.out.println("\n ==== MyArrayList 조회 ====");
        System.out.println("\nmyArrayList - 앞 위치 조회");
        getIndex(myArrayList, loop, 0); //0ms

        System.out.println("\nmyArrayList - 중간위치 조회");
        getIndex(myArrayList, loop, size / 2); //0ms

        System.out.println("\nmyArrayList - 마지막 위치 조회");
        getIndex(myArrayList, loop, size); //0ms


        System.out.println("\n ==== MyLinkedList 조회====");
        System.out.println("\nmyLinkedList - 앞 위치 조회"); //0ms
        getIndex(myLinkedList, 10000, 0);

        System.out.println("\nmyLinkedList - 중간위치 조회");
        getIndex(myLinkedList, 10000, size / 2); //283ms

        System.out.println("\nmyLinkedList - 마지막 위치 조회");
        getIndex(myLinkedList, 10000, size - 1); //533ms


        System.out.println("**************** 데이터 검색 ****************");
        System.out.println("\n ==== MyArrayList 검색 ====");
        search(myArrayList, loop, 0); //1 ms
        search(myArrayList, loop, size / 2); // 96 ms
        search(myArrayList, loop, size - 1); //194 ms

        System.out.println("\n ==== MyLinkedList 검색 ====");
        search(myLinkedList, loop, 0); // 0ms
        search(myLinkedList, loop, size / 2); // 693ms
        search(myLinkedList, loop, size - 1); // 1326ms
    }


      /*
         이론상으로 검색, addMid() 의 경우 MyArrayList 와 MyLinkedList 의 성능이 비슷해야하나 MyArrayList가 더 빠르다

         arrayList: 메모리에서도 연속적으로 위치
         -> 메모리 접근 속도가 더 빠름
         -> CPU 캐시 효율 좋음

         linkedList: 개별의 객체로 존재, 다음 요소의 참조 저장
         -> 메모리 접근 속도 상대적으로 느림
         -> CPU 캐시 효율 떨어짐

         데이터를 앞쪽 위치에서 추가 & 삭제 빈번하게 일어나는 경우가 아닐 경우
         웬만하면 arrayList 추천
    */

    private static void addFirst(MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i);
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("%s - size: %d, 소요시간: %d ms\n",
                "addFirst()", size, (endTime - startTime));
    }

    private static void addMid(MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(list.size() / 2, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("%s - size: %d, 소요시간: %d ms\n",
                "addMid()", size, (endTime - startTime));
    }

    private static void addLast(MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("%s - size: %d, 소요시간: %d ms\n",
                "addLast()", size, (endTime - startTime));
    }

    private static void getIndex(MyList<Integer> list, int loop, int index) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.get(index);
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("%s - 반복횟수: %d, 소요시간: %d ms\n",
                "getIndex()", loop, (endTime - startTime));
    }


    private static void search(MyList<Integer> list, int loop, int findValue) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.indexOf(findValue);
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("%s - 반복횟수: %d, 소요시간: %d ms\n",
                "getIndex()", loop, (endTime - startTime));
    }
}
