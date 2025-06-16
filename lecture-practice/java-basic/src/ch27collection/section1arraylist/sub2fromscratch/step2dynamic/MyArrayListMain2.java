package ch27collection.section1arraylist.sub2fromscratch.step2dynamic;

public class MyArrayListMain2 {
    public static void main(String[] args) {
        MyArrayListV2 list = new MyArrayListV2();

        System.out.println("\n==== capacity 초과 전 ====");
        list.add("a");
        System.out.println(list);
        list.add("b");
        System.out.println(list);
        list.add("c");
        System.out.println(list);
        list.add("d");
        System.out.println(list);
        list.add("e");
        System.out.println(list);


        System.out.println("\n==== capacity 초과 후 ====");
        list.add("f"); // capacity를 증가시키고, 새로운 배열에 정상적으로 세팅
        System.out.println(list);

        

        /*
        설정한 capacity 값에 도달하면
        capacity 값을 증가시키고 새로운 배열로 교체
        새로운 배열에 기존 값 복사
        
        배열을 새로 복사해서 만드는 연산은 시간소모가 크므로, 가능한 빈번하게 일어나지 않도록 조절
        그러나 너무 크게 증가시키면 낭비 메모리가 큰 단점
        -> 보통 50% 증가하는 방법 사용

         next step)
            용량을 동적으로 조절하게끔 구현했으니, 이번엔 기능을 추가해보자
        */
    }
}
