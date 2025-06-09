package ch27collection.section1arraylist.sub2fromscratch.step3addmethod;

public class MyArrayListMain3 {
    public static void main(String[] args) {
        MyArrayListV3 list = new MyArrayListV3();

        // 마지막 위치에 추가
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        System.out.println("==== 배열 값 세팅 ====");
        System.out.println(list);


        System.out.println("\n==== 특정 위치에 값 추가 ====");
        System.out.println("\n 맨 뒤에 값 추가"); //O(1)
        list.add(list.size(), "addLast");
        System.out.println(list);

        System.out.println("\n 맨 앞에 값 추가");
        list.add(0, "addFirst"); //O(n)
        System.out.println(list);

        System.out.println("\n==== 특정 위치의 값 삭제 ====");
        System.out.println("\n 맨 뒤의 값 삭제");  //O(1)
        list.remove(list.size()-1);
        System.out.println(list);
        System.out.println("\n 맨 앞의 값 삭제"); //O(n)
        list.remove(0);
        System.out.println(list);


        /*
        배열 리스트는 마지막위치에 데이터 추가, 삭제 -> O(1)
        중간이나 앞에 데이터 추가, 삭제 -> O(n)
        -> 마지막 외의 위치에서 변경작업하는 것이 잦으면, 다른 자료구조를 고려 ex) 연결리스트

         next step)
            구현한 배열 리스트의 타입 안정성을 위해
            제네릭을 도입해보자
        */
    }
}
