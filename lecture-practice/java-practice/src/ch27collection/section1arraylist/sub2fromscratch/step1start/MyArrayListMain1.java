package ch27collection.section1arraylist.sub2fromscratch.step1start;

public class MyArrayListMain1 {
    public static void main(String[] args) {
        MyArrayListV1 list = new MyArrayListV1();

        System.out.println("=== 데이터추가 ===");
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

        System.out.println("list.get(0): " + list.get(0));
        System.out.println("list.get(1): " + list.get(1));
        System.out.println("list.get(2): " + list.get(2));

        System.out.println("\nlist.indexOf(\"a\") = " + list.indexOf("a"));

        System.out.println("\nlist.set(0,\"A\") = " + list.set(0, "A")); //a
        System.out.println(list);

        list.add("e");

        // 범위 초과 (이미 capacity에 도달한 상태라면 예외 발생)
        //list.add("f"); //ArrayIndexOutOfBoundsException



        /*
        설정한 capacity 값에 도달하면, 더이상 데이터 추가 불가
        -> 기존 배열과 같이 크기가 정적인 상태

         next step)
            capacity가 동적으로 늘어날 수 있도록 코드를 변경해보자
        */
    }
}
