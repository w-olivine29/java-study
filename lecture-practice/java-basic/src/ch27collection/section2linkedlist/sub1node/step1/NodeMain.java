package ch27collection.section2linkedlist.sub1node.step1;

public class NodeMain {
    public static void main(String[] args) {

        // 노드 생성 후 연결 a -> b -> c
        Node first = new Node("a");
        first.next = new Node("b");
        first.next.next = new Node("c");

        System.out.println("모든 노드 탐색");
        System.out.println("first.item: " + first.item);
        System.out.println("first.next.item: " + first.next.item);
        System.out.println("first.next.next.item: " + first.next.next.item);


        System.out.println("모든 노드 탐색 - while문");
        Node node = first;
        while (node != null) {
            System.out.println(node.item);
            node = node.next;
        }
    }
}
