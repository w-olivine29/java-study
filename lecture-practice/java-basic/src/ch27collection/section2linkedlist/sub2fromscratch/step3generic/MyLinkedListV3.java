package ch27collection.section2linkedlist.sub2fromscratch.step3generic;

/*
배열리스트 이건 연결리스트이건, 둘 다 리스트 자료구조이기때문에, 
사용하는 입장에서는 거의 비슷하게 느껴지게 구현해야함

구현해야할 public method 목록)
    - size()
    - add(E e)
    - add(int index, E e)
    - set(int index, E e)
    - remove(int index)
    - get(int index)
    - indexOf(E e)
    
v3 수정사항
   Node를 중첩클래스로 변경
*/
public class MyLinkedListV3<E> {

    private Node<E> first;
    private int size;

    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (first == null) {
            first = newNode;
        } else {
            getLastNode().next = newNode;
        }
        size++;
    }

    // prev - new - prev.next
    public void add(int index, E element) {

        Node<E> newNode = new Node<>(element);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node<E> prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    // prev - removeNode.next
    public E remove(int index) {
        Node<E> removeNode = getNode(index);
        E removeItem = removeNode.item;

        if (index == 0) {
            first = first.next;
        } else {
            Node<E> prev = getNode(index - 1);
            prev.next = removeNode.next;
        }

        // 객체의 참조를 명시적으로 끊어 GC가 더 빨리 회수할 수 있도록 유도? (큰 객체 참조 시 유의미?)
        removeNode.item = null;
        removeNode.next = null;

        size--;
        return removeItem;
    }

    // 기존 값 반환
    public E set(int index, E element) {
        Node<E> node = getNode(index);

        E oldValue = node.item;
        node.item = element;

        return oldValue;
    }

    public E get(int index) {
        return getNode(index).item;
    }

    private Node<E> getNode(int index) {
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int indexOf(E element) {

        int index = 0;
        for (Node<E> node = first; node != null; node = node.next) {
            if (element.equals(node.item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    private Node<E> getLastNode() {
/*        Node node = first;
        while (node.next != null) {
            node = node.next;
        }

        return node;*/

        return getNode(size - 1);
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyLinkedListV1{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }


    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();

            Node<E> node = this;

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
}
