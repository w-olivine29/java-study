package ch27collection.section4hash.sub2hash;

import java.util.Arrays;

public class HashStart3_Remainder {

    static final int CAPACITY = 10;

    public static void main(String[] args) {

         // 배열[값 % CAPACITY] = 값; -> CAPACITY보다 큰 인덱스가 나올 수 없음(메모리 낭비 줄일 수 있음)
        Integer[] arr = new Integer[CAPACITY];
        add(arr,1); //1번 인덱스
        add(arr,2); //2번 인덱스
        add(arr,3); //3번 인덱스
        add(arr,50); //0번 인덱스
        add(arr,99); //9번 인덱스

        System.out.println(Arrays.toString(arr)); //[50, 1, 2, 3, null, null, null, null, null, 99]

        int searchValue = 99;
        System.out.println(searchValue(arr, searchValue)); //O(1)


        /*
            해시 인덱스 사용의 장점과 한계

            - 해시 인덱스: 원래 값을 특정 계산을 통해 배열 인덱스로 변환한 값
            - 해시 인덱스를 사용하면, "값을 배열의 인덱스로 변환" 하여 메모리 사용 효율을 높일 수 있음


            문제점: 해시 충돌 (Hash Collision)
            - 서로 다른 값이 동일한 해시 인덱스를 가질 수 있음
              예: 5와 55 → 해시 인덱스가 동일하게 5로 계산될 수 있음

            다음 단계:
            - 해시 충돌을 해결하는 방법을 구현해보자
        */

    }


    // 인덱스만 해시인덱스를 사용, 값은 본래의 값 저장
    private static void add(Integer[] arr, int value) {
        arr[hashIndex(value)] = value;
    }

    private static int hashIndex(int value) {
        return value % CAPACITY;
    }
    // 데이터 조회 시 데이터의 값을 인덱스로 사용하여 조회 -> O(1)
    // 속도성능은 up, but 메모리 낭비

    private static Integer searchValue(Integer[] arr, int searchValue) {
        return arr[hashIndex(searchValue)];
    }
}
