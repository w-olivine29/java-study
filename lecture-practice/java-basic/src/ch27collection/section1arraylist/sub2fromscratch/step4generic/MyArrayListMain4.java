package ch27collection.section1arraylist.sub2fromscratch.step4generic;

public class MyArrayListMain4 {
    public static void main(String[] args) {

        MyArrayListV4<String> strList = new MyArrayListV4<>();
        strList.add("*");
        strList.add("*");
        strList.add("*");
        //strList.add(1);
        System.out.println(strList);

        MyArrayListV4<Integer> integerList = new MyArrayListV4<>();
        integerList.add(1);
        integerList.add(1);
        integerList.add(1);
        //integerList.add("1");
        System.out.println(integerList);


        /*
          제네릭을 도입함으로써, 객체 생성 시에 결정된 타입으로만 안전하게 저장, 조회 등 가능
           -> 코드 재사용성, 타입 안정성 확보


       next step)
          배열 리스트는 필요한 배열의 크기를 미리 확보
            -> 사용하지 않는 공간 낭비
          배열 중간에 데이터 추가, 삭제 - O(n)
            -> 데이터 이동필요 (데이터가 많을수록 성능하락)
            
          낭비되는 메모리 없이, 필요한 만큼의 메모리만 확보해서 사용하고
          데이터 추가, 삭제를 효율적으로 하는 자료구조는 없을까?
          -> 연결리스트
            (노드와 노드를 연결하는 방식)
        */
    }
}
