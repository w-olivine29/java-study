package ch27collection.section10utils.step3empty;

import java.util.*;

public class EmptyList {
    public static void main(String[] args) {

        // 빈 가변 리스트 생성
        List<Integer> list = new ArrayList<>();

        // 불변 리스트 생성
        List<Integer> emptyList = Collections.emptyList(); // Java5
        //emptyList.add(1); //Immutable object is modified

        List<Integer> ofList1 = List.of(); //Java9
        List<Integer> ofList2 = List.of(new Integer[]{1,2,3,4});
        //List<Integer> ofList3 = List.of(list); //컬렉션객체를 넣을 수는 없음

        System.out.println("ofList.getClass() = " + ofList1.getClass()); //ImmutableCollections$ListN
        System.out.println("emptyList.getClass() = " + emptyList.getClass()); //Collections$EmptyList

//==================================================================================================

        Integer[] arr = {1,2,3,4,5};

        // Arrays.asList(): 길이는 불변, 요소는 가변 (add, remove x)
        // 배열의 참조값을 넘겨서 만든다. (List.of() 처럼 값을 복사해서 새로운 객체를 만드는 것이 아님)
        // 엄청 큰 배열을 토대로 List를 만드는 경우 asList를 쓰는게 성능상 더 효과적일 수는 있음
        List<Integer> asList = Arrays.asList(arr);
        asList.set(0,0);
        asList.set(1,0);
        asList.set(2,0);
        asList.set(3,0);
        asList.set(4,0);

        // 참조값이 같기 때문에 asList를 변경시 기존 배열의 값도 변경된다.
        System.out.println("arr: "+ Arrays.toString(arr)); //arr: [0, 0, 0, 0, 0]
        System.out.println("asList: " + asList); //asList: [0, 0, 0, 0, 0]

    }
}
