package ch27collection.section8deque.sub3deque;

import java.util.*;

public class DequeMain {
    public static void main(String[] args) {

        // 상속 & 구현) Queue <- Deque <- ArrayDeque, LinkedList (성능 상 LinkedList 보다 ArrayDeque 추천)

        // 대체적으로 성능이 ArrayDeque > LinkedList
        // 이론상 삽입, 삭제 시 LinkedList가 우수해야하나 실제 사용환경에선 여러 요소로 인해 ArrayDeque 가 성능이 더 좋을 때가 많음
        Deque<Integer> deque = new ArrayDeque<>();

        //데이터 추가 ==============================================================
        deque.offer(1); // offer()는 Queue 방식으로 작동, 요소를 뒤에 추가 (offerLast와 동일)

        deque.offerFirst(2);
        System.out.println("deque = " + deque); //[2, 1]

        deque.offerLast(3);
        System.out.println("deque = " + deque); //[2, 1, 3]

        // 다음 요소 확인 (단순 조회) ====================================================
        System.out.println("deque.peek() = " + deque.peek()); // peek()는 Queue 방식으로 작동, 맨 앞의 요소 조회 (peekFirst와 동일)

        System.out.println("deque.peekFirst() = " + deque.peekFirst()); //2
        System.out.println("deque.peekLast() = " + deque.peekLast()); //3

        // 데이터 꺼내기 ============================================================
        System.out.println("deque.poll() = " + deque.poll()); // poll()는 Queue 방식으로 작동, 맨앞의 요소 꺼내기 (pollFirst 동일)
        System.out.println("deque = " + deque); //[1,3]

        System.out.println("deque.pollFirst() = " + deque.pollFirst());
        System.out.println("deque = " + deque); //[1]

        System.out.println("deque.pollLast() = " + deque.pollLast());
        System.out.println("deque = " + deque); //[]

    }
}
