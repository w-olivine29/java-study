package ch27collection.section8deque.sub4;

import java.util.*;

public class DequeStackMain {
    public static void main(String[] args) {

        // Stack 자료구조가 필요하다면 Stack클래스가 아닌 Deque 사용
        Deque<Integer> deque = new ArrayDeque<>();
        //Deque<Integer> deque = new LinkedList<>(); //성능 상 LinkedList 보다 ArrayDeque 추천

        // 데이터추가
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);
        System.out.println("deque = " + deque);
        
        // 다음 꺼낼 데이터 확인 (단순 조회)
        System.out.println("deque.peek() = " + deque.peek()); //4
        
        // 데이터 꺼내기
        System.out.println("deque.pop() = " + deque.pop()); //4
        System.out.println("deque.pop() = " + deque.pop()); //3
        System.out.println("deque.pop() = " + deque.pop()); //2
        System.out.println("deque.pop() = " + deque.pop()); //1
        //System.out.println("deque.pop() = " + deque.pop()); // NoSuchElementException

        
    }
}
