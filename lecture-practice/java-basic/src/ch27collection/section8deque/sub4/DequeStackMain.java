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
        System.out.println("deque = " + deque); //[4, 3, 2, 1]
        
        // 다음 꺼낼 데이터 확인 (단순 조회)

        // Deque의 peek는 peekFirst 를 반환하기때문에, 스택 자료구조로 활용하려면, peekLast() 사용해야함
        System.out.println("deque.peek() = " + deque.peek()); //4
        System.out.println("deque.peekLast() = " + deque.peekLast()); //1

        // 데이터 꺼내기
        System.out.println("deque.pop() = " + deque.pop()); //4
        System.out.println("deque.pop() = " + deque.pop()); //3
        System.out.println("deque.pop() = " + deque.pop()); //2
        System.out.println("deque.pop() = " + deque.pop()); //1

        System.out.println("deque.peek() = " + deque.peek()); //null
        System.out.println("deque.peekLast() = " + deque.peekLast()); //null

        //System.out.println("deque.pop() = " + deque.pop()); // NoSuchElementException
        System.out.println("deque.pollLast() = " + deque.pollLast()); // null
        //System.out.println("deque.removeLast() = " + deque.removeLast()); // NoSuchElementException
        
    }
}
