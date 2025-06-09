package ch27collection.section2linkedlist.sub2fromscratch.step2addremove;


/*
배열리스트 이건 연결리스트이건, 둘 다 리스트 자료구조이기때문에,
사용하는 입장에서는 거의 비슷하게 느껴지게 구현해야함

section1arraylist.sub2fromscratch의 MyArrayListMain 코드를 복사하고,
사용 객체만 MyLinkedListV2 로 교체

*/
public class MyLinkedListMain2 {
    public static void main(String[] args) {
        MyLinkedListV2 list = new MyLinkedListV2();

        // 마지막 위치에 추가
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        System.out.println("==== 배열 값 세팅 ====");
        System.out.println(list);


        System.out.println("\n==== 특정 위치에 값 추가 ====");
        System.out.println("\n 맨 뒤에 값 추가"); //O(N+1) -> O(n)   ( 자바의 LinkedList는 lastNode도 가지고 있기때문에 O(1) )
        list.add(list.size(), "addLast");
        System.out.println(list);

        System.out.println("\n 맨 앞에 값 추가");
        list.add(0, "addFirst"); //O(1)
        System.out.println(list);

        System.out.println("\n==== 특정 위치의 값 삭제 ====");
        System.out.println("\n 맨 뒤의 값 삭제");  //O(n+1) -> O(n)  ( 자바의 LinkedList는 lastNode도 가지고 있기때문에 O(1) )
        list.remove(list.size() - 1);
        System.out.println(list);

        System.out.println("\n 맨 앞의 값 삭제"); //O(1)
        list.remove(0);
        System.out.println(list);

    }
}
