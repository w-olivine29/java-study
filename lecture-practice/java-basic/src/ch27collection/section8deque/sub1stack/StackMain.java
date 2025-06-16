package ch27collection.section8deque.sub1stack;

import java.util.*;

public class StackMain {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("stack = " + stack); //[1, 2, 3, 4]

        // peek(): 다음에 꺼낼 요소 조회 (꺼내는 것이 아님)
        Integer peek = stack.peek();
        System.out.println("peek = " + peek); //4
        System.out.println("stack = " + stack); //[1, 2, 3, 4]

        // pop(): 마지막 위치에 있는 요소 꺼내기
        Integer pop = stack.pop();
        System.out.println("pop = " + pop); //4
        System.out.println("stack = " + stack); //[1, 2, 3]

        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("stack = " + stack); // []

        // 없는 걸 꺼내려하거나 보는건 불가
        //stack.pop(); // EmptyStackException
        //stack.peek(); // EmptyStackException

        System.out.println("stack.isEmpty() = " + stack.isEmpty()); //true



        /* Stack 클래스 사용 X
            - Stack 클래스는 사용 지양
            - 오래된 Vector 기반으로 동기화로 인해 성능 저하
            - Deque(ArrayDeque)가 더 빠르고 유연
            - Stack은 인터페이스(Deque, Queue) 미구현 → 다형성 불리
            - 대안: ArrayDeque 사용 권장 (단일 스레드 환경에서 성능 우수)
        */
    }
}
