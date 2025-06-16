package ch27collection.section2linkedlist.sub1node.step3addmethod;

/* 기능 추가
- 모든 노드 탐색
- 마지막 노드 조회
- 특정 index의 노드 조회
- 노드에 데이터 추가
*/
public class NodeMain {
    public static void main(String[] args) {

        // 노드 생성 후 연결 a -> b -> c
        Node first = new Node("a");
        first.next = new Node("b");
        first.next.next = new Node("c");

        System.out.println(first);

        System.out.println("\n== 모든 노드 탐색 ==");
        printFollowingNodes(first);


        System.out.println("\n== 마지막 노드 조회하기 ==");
        Node lastNode = getLastNode(first);
        System.out.println("마지막 노드: " + lastNode);


        System.out.println("\n== 특정 index의 노드 조회하기 ==");
        int index = 2;
        Node thirdNode = getNode(first, index);
        System.out.println("thirdNode.item: " + thirdNode.item);

        System.out.println("\n== 데이터 추가 ==");
        add(first, "d");
        System.out.println(first);

        add(first, "e");
        System.out.println(first);

        add(first, "f");
        System.out.println(first);


    }

    // 마지막 노드에 연결해야함
    private static void add(Node node, String value) {
        getLastNode(node).next = new Node(value);
    }

    private static void printFollowingNodes(Node node) {

        while (node != null) {
            System.out.println(node.item);
            node = node.next;
        }
    }

    private static Node getNode(Node first, int index) {
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private static Node getLastNode(Node node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }
}
