package ch27collection.section2linkedlist.sub1node.step2;

// 예제를 단순화 하기위해  private 적용 x
public class Node {
    Object item;
    Node next;

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node node = this;

        sb.append("[");
        while (node != null) {
            sb.append(node.item);

            if (node.next != null) {
                sb.append(" -> ");
            }
            node = node.next;
        }
        sb.append("]");

        return sb.toString();
    }
}
