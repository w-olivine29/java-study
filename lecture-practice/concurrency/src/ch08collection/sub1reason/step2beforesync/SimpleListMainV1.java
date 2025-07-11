package ch08collection.sub1reason.step2beforesync;

import ch08collection.sub1reason.SimpleList;

// 단일스레드 환경
public class SimpleListMainV1 {
    public static void main(String[] args) {
        SimpleList list = new BasicList();
        list.add("A");
        list.add("B");
        System.out.println("list = " + list);
    }
}
