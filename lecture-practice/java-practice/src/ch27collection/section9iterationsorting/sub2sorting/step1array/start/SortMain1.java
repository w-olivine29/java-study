package ch27collection.section9iterationsorting.sub2sorting.step1array.start;

import java.util.Arrays;
import java.util.Comparator;

//배열 정렬
public class SortMain1 {
    public static void main(String[] args) {
        Integer[] arr = {4, 5, 2, 8, 1};

        // 파라미터 순서참고) 타켓 배열 - 시작인덱스 - 끝인덱스 - Comparator

        // Arrays.sort() -> O(n log n)  퀵소트 - 듀얼 피벗 퀵소트 - 팀소트
//=================================================================================

        // 기본정렬 (전체 오름차순)
        Arrays.sort(arr);
        System.out.println("after sorting = " + Arrays.toString(arr));

//==================================================================================

        // Comparator
        arr = new Integer[]{1, 3, 6, 0, -3, -5, 2, 11};

        //오름차순 정렬
        Arrays.sort(arr, new AscComparator());
        System.out.println(Arrays.toString(arr)); //[-5, -3, 0, 1, 2, 3, 6, 11]

        //내림차순 정렬
        Arrays.sort(arr, new DescComparator());
        System.out.println(Arrays.toString(arr)); //[11, 6, 3, 2, 1, 0, -3, -5]
        
        //Comparator 의 reversed()
        Arrays.sort(arr, new DescComparator().reversed()); //오름차순
        Arrays.sort(arr, new AscComparator().reversed()); //내림차순


    }

    private static class AscComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return (o1 > o2) ? 1 : (o1 == o2) ? 0 : -1;
            //return Integer.compare(o1,o2)
        }
    }

    private static class DescComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return ((o1 > o2) ? 1 : (o1 == o2) ? 0 : -1) * -1; //오름차순의 반대
            //return Integer.compare(o2,o1)
        }
    }

}
