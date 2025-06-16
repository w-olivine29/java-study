package ch27collection.section4hash.sub2hash;

import java.util.Arrays;
import java.util.LinkedList;

public class HashStart5_Collision {


    // 용량을 변경할 때마다 충돌 확률이 달라지는 것을 볼 수 있음 (보통 데이터의 수가 배열크기의 75% 넘지않으면 자주 충돌X)
    static final int CAPACITY = 20;

    public static void main(String[] args) {

        //연결리스트를 사용한 이유: 해시충돌할 확률이 적고 배열리스트는 공간을 미리 확보해야하기때문
        LinkedList<Integer>[] listArr = new LinkedList[CAPACITY];

        // listArr 초기화
//    실수한 부분:
//        for-each문 사용 시의 변수는 배열의 각 요소를 "복사" 한 로컬 변수
//        아래코드는 복사본에 새 객체를 할당 -> 실제 listArr 자체의 내용 변경 x
        for (LinkedList<Integer> list : listArr) {
            list = new LinkedList<>();
        }
        System.out.println(Arrays.toString(listArr)); // [null, null, null, null, null, null, null, null, null, null]


        for (int i = 0; i < listArr.length; i++) {
            listArr[i] = new LinkedList<>();
        }
        System.out.println(Arrays.toString(listArr)); // [[], [], [], [], [], [], [], [], [], []]


        // 데이터 추가
        add(listArr, 1);
        add(listArr, 1); //중복
        add(listArr, 3);
        add(listArr, 5);
        add(listArr, -7);
        add(listArr, 21);
        add(listArr, -31);
        add(listArr, 11);
        add(listArr, 9);
        add(listArr, 70);
        add(listArr, 0);
        add(listArr, 99);
        System.out.println(Arrays.toString(listArr));

        System.out.println("listArr.contains(-31) => " + contains(listArr, -31));
        System.out.println("listArr.contains(-12) => " + contains(listArr, -12));



        /*
            이론상으로 해시알고리즘은 O(1 + n) -> O(n) 이지만
            용량을 적절히 잡아주면 충돌이 거의 없기때문에
            보통 O(1) 의 성능을 보여주는 편이다.

            다음 단계:
            - 구현했던 MyHashSet 개선
        */

    }


    private static void add(LinkedList<Integer>[] listArr, int value) {

        LinkedList<Integer> list = listArr[hashIndex(value)];
        if (!list.contains(value)) {
            list.add(value);
        }
        // 중복 값은 무시 (set 자료구조)
    }

    private static int hashIndex(int value) {
        if (value < 0) {
            value *= -1;
        }
        return value % CAPACITY;
    }

    private static boolean contains(LinkedList<Integer>[] listArr, int value) {
        return listArr[hashIndex(value)].contains(value);
    }

}
