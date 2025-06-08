package ch27collection.section1arraylist.sub1array;

import java.util.Arrays;

// 수정x, 추가(o)
// 배열뿐만 아니라 다른 자료구조들도 어느위치에 데이터를 넣느냐에 따라 성능이 다름
public class ArrayMain2_AddData {
    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        System.out.println("arr = " + Arrays.toString(arr));


        /* 배열의 첫번째 위치에 추가
            - 배열의 첫번째 위치 찾기 -> O(1)
            - 모든 데이터를 배열 크기만큼 한 칸씩 이동 -> O(n)

            -> O(1+n) -> O(n)  (빅오표기법에서 상수는 제거)
        */
        System.out.println("\n배열의 첫번째 위치에 새로운 값 추가 - O(n)");
        int newValue = 5;
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = newValue;
        System.out.println("arr = " + Arrays.toString(arr));



         /* 배열의 중간 위치에 추가
            - 배열의 중간 위치 찾기 -> O(1)
            - 중간 위치 인덱스의 우측 데이터들을 한 칸씩 이동 -> O(n/2)

            -> O(1+(n/2)) -> O(n)  (빅오표기법에서 상수는 제거)
        */
        System.out.println("\n배열의 중간 위치에 새로운 값 추가 - O(n)");
        int idx = arr.length / 2;
        for (int i = arr.length - 1; i > idx; i--) {
            arr[i] = arr[i - 1];
        }
        arr[idx] = newValue;
        System.out.println("arr = " + Arrays.toString(arr));


        // 배열의 마지막 위치에 추가 - O(1)
        System.out.println("\n배열의 마지막 위치에 새로운 값 추가 - O(1)");
        arr[arr.length - 1] = newValue;
        System.out.println(Arrays.toString(arr));
    }


    /* 배열의 한계
       배열은 생성할 때 크기를 정해야하고, 크기 변경 불가 (정적인 길이)
       만약 사용 중에 더 많은 공간이 필요해지면,
       더 큰 크기의 새로운 배열을 만들어 데이터를 옮겨야 한다.

       -> 크기가 동적인 배열은 없을까?
            -> List
            
      next step)
        자바에서 제공하는 List를 사용하기 전에, 직접 구현해보자
        직접 ArrayList 구현하기 (배열을 사용한 List -> ArrayList)
    */

}
