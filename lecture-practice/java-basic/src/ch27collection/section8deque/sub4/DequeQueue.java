package ch27collection.section8deque.sub4;

import java.util.LinkedList;
import java.util.Queue;

public class DequeQueue {
    public static void main(String[] args) {
        // 상속 & 구현) Queue <- Deque <- ArrayDeque, LinkedList (성능 상 LinkedList 보다 ArrayDeque 추천)

        //Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> queue = new LinkedList<>();

        // Queue는 단방향으로만 제공 (선입선출 형태)
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println("queue = " + queue);

        // 다음 꺼낼 데이터 확인(단순 조회)
        System.out.println("queue.peek() = " + queue.peek()); //1
        
        //데이터 꺼내기
        while(queue.peek() != null){ // 요소가 없으면 null 반환
            System.out.println("queue.poll() = " + queue.poll());
        }
        
        // 요소가 없을 때 poll() -> null 반환
        System.out.println("queue.poll() = " + queue.poll());

    }
}
