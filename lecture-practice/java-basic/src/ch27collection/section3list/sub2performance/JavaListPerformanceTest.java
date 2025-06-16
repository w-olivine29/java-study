package ch27collection.section3list.sub2performance;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JavaListPerformanceTest {
    public static void main(String[] args) {

        int size = 50_000;
        System.out.println("**************** 데이터 추가 ****************");
        System.out.println("\n==== Arraylist 추가 ====");

        // 데이터를 한칸 씩 미는 것이 아닌 배열 고속복사로 성능 최적화 (시스템 레벨에서 최적화된 메모리 고속 복사연산)
        addFirst(new ArrayList<>(), size); //1188 -> 85ms
        addMid(new ArrayList<>(), size); //696 -> 44ms
        addLast(new ArrayList<>(), size); //2ms


        System.out.println("\n==== LinkedList 추가 ====");
        addFirst(new LinkedList<>(), size); //2ms
        addMid(new LinkedList<>(), size); //936ms
        addLast(new LinkedList<>(), size); //1ms

// ======================================================================================

        System.out.println();
        // 조회 & 검색 데이터 세팅
        int loop = 10000;
        ArrayList<Integer> arrayList = new ArrayList<>();
        addLast(arrayList, size);

        LinkedList<Integer> linkedList = new LinkedList<>();
        addFirst(linkedList, size);

        System.out.println("**************** 데이터 조회 ****************");

        System.out.println("\n ==== ArrayList 조회 ====");
        System.out.println("\nArrayList - 앞 위치 조회");
        getIndex(arrayList, loop, 0); //0ms

        System.out.println("\nArrayList - 중간위치 조회");
        getIndex(arrayList, loop, size / 2); //0ms

        System.out.println("\nArrayList - 마지막 위치 조회");
        getIndex(arrayList, loop, size-1); //0ms


        System.out.println("\n ==== LinkedList 조회====");
        System.out.println("\nLinkedList - 앞 위치 조회");
        getIndex(linkedList, 10000, 0); // 0ms

        System.out.println("\nLinkedList - 중간위치 조회");
        getIndex(linkedList, 10000, size / 2); //311ms

        System.out.println("\nLinkedList - 마지막 위치 조회");
        getIndex(linkedList, 10000, size - 1); //0ms (자바 연결리스트는 lastNode 참조값도 가짐)


        System.out.println("**************** 데이터 검색 ****************");
        System.out.println("\n ==== ArrayList 검색 ====");
        search(arrayList, loop, 0); //1 ms
        search(arrayList, loop, size / 2); // 96 ms
        search(arrayList, loop, size - 1); //194 ms

        System.out.println("\n ==== LinkedList 검색 ====");
        search(linkedList, loop, 0); // 0ms
        search(linkedList, loop, size / 2); // 693ms
        search(linkedList, loop, size - 1); // 1326ms
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

    private static void addFirst(List<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i);
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("%s - size: %d, 소요시간: %d ms\n",
                "addFirst()", size, (endTime - startTime));
    }

    private static void addMid(List<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(list.size() / 2, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("%s - size: %d, 소요시간: %d ms\n",
                "addMid()", size, (endTime - startTime));
    }

    private static void addLast(List<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("%s - size: %d, 소요시간: %d ms\n",
                "addLast()", size, (endTime - startTime));
    }

    private static void getIndex(List<Integer> list, int loop, int index) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.get(index);
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("%s - 반복횟수: %d, 소요시간: %d ms\n",
                "getIndex()", loop, (endTime - startTime));
    }


    private static void search(List<Integer> list, int loop, int findValue) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.indexOf(findValue);
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("%s - 반복횟수: %d, 소요시간: %d ms\n",
                "getIndex()", loop, (endTime - startTime));
    }
}
