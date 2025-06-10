package ch27collection.section4hash.sub2hash;

import java.util.Arrays;

public class HashStart1_Start {
    public static void main(String[] args) {
        Integer[] arr = new Integer[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        System.out.println(Arrays.toString(arr));

        int searchValue = 5;

        //O(n)
        for (Integer integer : arr) {
            if (searchValue == integer) {
                System.out.println(integer);
            }
        }

        /*
            특정 값을 찾으려면 배열에 들어있는 데이터를 모두 찾아서 비교
            -> O(n)
            
            next step)
                데이터 검색 시의 성능을 O(1)으로 개선해보자
        */
    }
}
