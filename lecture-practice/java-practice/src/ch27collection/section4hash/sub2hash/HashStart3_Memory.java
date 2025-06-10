package ch27collection.section4hash.sub2hash;

import java.util.Arrays;

public class HashStart3_Memory {
    public static void main(String[] args) {
        
        //입력: {1,2,5,50,99} -> {null, 1, 2, null, null, 5, null.......... 99}
        Integer[] arr = new Integer[100];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[50] = 50;
        arr[99] = 99;
        System.out.println(Arrays.toString(arr));

        int searchValue = 99;
        System.out.println(searchValue(arr, searchValue)); //O(1)


        /*
            데이터의 값 자체를 배열의 인덱스와 맞추어 저장 (데이터의 값 자체를 배열의 인덱스로 사용)
            인덱스를 통한 데이터 검색이 가능 -> O(1)

            그러나 값의 범위가 크면 낭비되는 메모리가 크다.

            next step)
                나머지 연산을 통해 메모리 문제를 해결해보자

        */
    }


    // 데이터 조회 시 데이터의 값을 인덱스로 사용하여 조회 -> O(1)
    // 속도성능은 up, but 메모리 낭비
    private static Integer searchValue(Integer[] arr, int searchValue) {
        return arr[searchValue];
    }
}
