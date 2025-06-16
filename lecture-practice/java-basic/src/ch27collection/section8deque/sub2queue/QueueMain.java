package ch27collection.section8deque.sub2queue;

import java.util.*;

public class QueueMain {
    public static void main(String[] args) {

        // 상속 & 구현) Queue <- Deque <- ArrayDeque, LinkedList (성능 상 LinkedList 보다 ArrayDeque 추천)

        Deque<Integer> arrayDequeQ = new ArrayDeque<>();
        Queue<Integer> linkedListQ = new LinkedList<>();

        // LinkedList는 List와 Queue를 모두 구현하므로, 다형성으로 참조하지않으면 두 종류의 기능을 모두 사용할 수 있음
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1); //List
        linkedList.get(0);

        linkedList.offer(1); //Queue
        linkedList.poll();


        // Queue는 단방향으로만 제공 (선입선출 형태)
        
        // 데이터 추가
        arrayDequeQ.offer(1);
        arrayDequeQ.offer(2);
        arrayDequeQ.offer(3);
        System.out.println("arrayDequeQ = " + arrayDequeQ); //[1, 2, 3]

        // 다음 요소 꺼내지 않고 조회
        System.out.println("arrayDequeQ.peek() = " + arrayDequeQ.peek());
        
        //데이터 꺼내기
        System.out.println("arrayDequeQ.poll() = " + arrayDequeQ.poll()); //3
        System.out.println("arrayDequeQ.poll() = " + arrayDequeQ.poll()); //2
        System.out.println("arrayDequeQ.poll() = " + arrayDequeQ.poll()); //1
        System.out.println("arrayDequeQ = " + arrayDequeQ); //[]

        // 요소가 없는 경우
        // Queue 의 poll, peek는 null 반환  <-> Stack은 pop, peek 모두 에러발생
        System.out.println("arrayDequeQ.poll() = " + arrayDequeQ.poll()); //null
        System.out.println("arrayDequeQ.peek() = " + arrayDequeQ.peek());


        Deque<Integer> arrayDeque = arrayDequeQ;
        arrayDeque.peek(); //null
        //arrayDeque.pop(); //NoSuchElementException (pop은 에러발생)



    }
}
