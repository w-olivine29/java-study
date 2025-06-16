package ch27collection.section9iterationsorting.sub1iteration;

import java.util.Iterator;

public class MyArrayMain {
    public static void main(String[] args) {
        MyArray<String> myArray = new MyArray<>();
        myArray.add("a");
        myArray.add("b");
        myArray.add("c");
        myArray.add("d");
        myArray.add("e");
        myArray.add("f");

        Iterator<String> iterator = myArray.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


        // 자료형이 배열이거나 Iterable를 구현한 클래스라면 향상된 for문 사용가능
        // 컴파일시점에 해당 코드를 hasNext(), next() 를 사용하는 반복문으로 바꿔줌
        for (String string : myArray) {
            System.out.println("string = " + string);
        }


    }
}
