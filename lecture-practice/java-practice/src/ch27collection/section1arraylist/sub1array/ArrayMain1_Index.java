package ch27collection.section1arraylist.sub1array;


import java.util.Arrays;

public class ArrayMain1_Index {
    public static void main(String[] args) {
        int[] arr = new int[4];

        System.out.println("===== index 입력 O(1) =====");
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        System.out.println(Arrays.toString(arr));


        System.out.println("===== index 변경 O(1) =====");
        arr[0] = 11;
        arr[1] = 21;
        arr[2] = 31;
        arr[3] = 41;
        System.out.println(Arrays.toString(arr));


        System.out.println("===== index 조회 O(1) =====");
        System.out.println("arr[0]: " + arr[0]);
        System.out.println("arr[1]: " + arr[1]);
        System.out.println("arr[2]: " + arr[2]);
        System.out.println("arr[3]: " + arr[3]);

    /* 배열의 접근
      1. 논리적 & 물리적 구조가 동일 (실제 메모리 상에서도 일렬로 붙어있음)
      2. 동일한 타입만 사용
      -> 시작시점 주소를 기준으로 계산해서 바로 접근가능 (  배열의 시작참조 + (자료의 크기 * 인덱스 위치)  )

      ex) arr 배열의 경우
       int 타입 배열 -> 4byte씩 공간 차지
          arr[0] -> 시작주소 + (4byte * 0)
          arr[3] -> 시작주소 + (4byte * 3)

         데이터양 상관없이 한번의 연산만으로 필요한 위치를 찾을 수 있다. O(1)
    */


        System.out.println(" ===== 배열 검색 O(n) =====");
        int value = 41;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + "번 인덱스 값: " + arr[i]);
            if (arr[i] == value) {
                System.out.println((i + 1) + "번 시도");
                break;
            }
        }
    /*  배열의 검색: 배열 내의 데이터를 찾는 것
        배열 내에 들어있는 데이터를 하나하나 다 비교해야한다. -> 배열의 크기가 클 수록 오랜 시간 소모할 확률 up

        배열의 순차 검색은 배열의 크기 만큼 연산 필요 (크기가 n이면 연산도 n번 필요) -> O(n)


        데이터가 많을 수록 더 많은 루프를 돌 확률이 높아진다.
    */


    }
}
