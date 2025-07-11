package ch08collection.sub1reason.step1intro;

import java.util.ArrayList;
import java.util.List;

public class SimpleListMainV0 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // 스레드1, 스레드2가 동시에 실행 가정
        list.add("A"); // 스레드1
        list.add("B"); // 스레드2

        System.out.println(list);
    }
}
/*
 add() 는 단순히 컬렉션에 데이터를 하나 추가 -> 과연 원자적 연산일까?
 컬렉션 프레임워크가 제공하는 대부분의 연산은 원자적인 연산 X
 
 컬렉션 관련 실습 코드, pdf 복습 (내부 구현로직)
*/
