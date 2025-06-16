package ch27collection.section2linkedlist.sub1node.step2;

public class NodeMain {
    public static void main(String[] args) {

        // 노드 생성 후 연결 a -> b -> c
        Node first = new Node("a");
        first.next = new Node("b");
        first.next.next = new Node("c");


        System.out.println("연결된 노드 출력 - while문");
        Node node = first;
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }

    }
}
