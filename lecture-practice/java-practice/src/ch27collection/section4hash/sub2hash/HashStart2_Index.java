package ch27collection.section4hash.sub2hash;

import java.util.Arrays;

public class HashStart2_Index {
    public static void main(String[] args) {
        
        //배열의 인덱스를 값으로 활용 (인덱스와 값을 동일하게 맞춤)
        Integer[] arr = new Integer[10];
        arr[2] = 2;
        arr[5] = 5;
        arr[6] = 6;
        arr[7] = 7;
        arr[9] = 9;
        System.out.println(Arrays.toString(arr));

        int searchValue = 9;
        System.out.println(searchValue(arr, searchValue));


        /*
            데이터의 값 자체를 배열의 인덱스와 맞추어 저장 (데이터의 값 자체를 배열의 인덱스로 사용)
            인덱스를 통한 데이터 검색이 가능 -> O(1)
        */
    }


    // 데이터 조회 시 데이터의 값을 인덱스로 사용하여 조회 -> O(1)
    // 속도성능은 up, but 메모리 낭비
    private static Integer searchValue(Integer[] arr, int searchValue) {
        return arr[searchValue];
    }
}
