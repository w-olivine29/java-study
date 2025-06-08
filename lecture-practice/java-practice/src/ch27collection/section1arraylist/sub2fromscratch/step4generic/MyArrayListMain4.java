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
        */
    }
}
