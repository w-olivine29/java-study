package ch27collection.section2linkedlist.sub2fromscratch.step1start;


/*
배열리스트 이건 연결리스트이건, 둘 다 리스트 자료구조이기때문에,
사용하는 입장에서는 거의 비슷하게 느껴지게 구현해야함

section1arraylist.sub2fromscratch의 MyArrayListMain  의 코드를 복사하고,
사용 객체만 MyLinkedListV1 로 교체

*/
public class MyLinkedListMain1 {
    public static void main(String[] args) {
        MyLinkedListV1 list = new MyLinkedListV1();

        System.out.println("=== 데이터추가 ===");  // O(n+1) -> O(n)
        list.add("a");
        System.out.println(list);
        list.add("b");
        System.out.println(list);
        list.add("c");
        System.out.println(list);
        list.add("d");
        System.out.println(list);


        System.out.println("\n=== 기능 사용 ===");
        System.out.println("list.size():  " + list.size());

        System.out.println("list.get(0): " + list.get(0)); //O(1)
        System.out.println("list.get(1): " + list.get(1)); //O(n)
        System.out.println("list.get(2): " + list.get(2)); //O(n)

        System.out.println("\nlist.indexOf(\"a\") = " + list.indexOf("a")); //O(n)

        System.out.println("\nlist.set(0,\"A\") = " + list.set(0, "A")); //O(1)
        System.out.println("\nlist.set(0,\"A\") = " + list.set(2, "A")); //O(n)
        System.out.println(list);
    }
}
