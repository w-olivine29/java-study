package ch27collection.section1arraylist.sub2fromscratch.step3addfunction;

public class MyArrayListMain3_Bad {
    public static void main(String[] args) {
        MyArrayListV3 numberlist = new MyArrayListV3();

        // 숫자만 입력 하기를 기대했으나
        numberlist.add(1);
        numberlist.add(2);
        numberlist.add("3");
        System.out.println(numberlist);
        Integer first = (Integer)numberlist.get(0);
        Integer second = (Integer)numberlist.get(1);
        //Integer third = (Integer)numberlist.get(3); //ClassCastException


        /*
         next step)
            구현한 배열 리스트의 타입 안정성을 위해
            제네릭을 도입해보자
        */
    }
}
