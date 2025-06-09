package ch27collection.section2linkedlist.sub2fromscratch.step2addremove;

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
    
v2 구현 목록
   - add(int index, E e)
   - remove(int index)
*/
public class MyLinkedListV2 {

    private Node first;
    private int size;

    public void add(Object element) {
        Node newNode = new Node(element);
        if (first == null) {
            first = newNode;
        } else {
            getLastNode().next = newNode;
        }
        size++;
    }

    // prev - new - prev.next
    public void add(int index, Object element) {

        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    // prev - removeNode.next
    public Object remove(int index) {
        Node removeNode = getNode(index);
        Object removeItem = removeNode.item;

        if (index == 0) {
            first = first.next;
        } else {
            Node prev = getNode(index - 1);
            prev.next = removeNode.next;
        }

        // 객체의 참조를 명시적으로 끊어 GC가 더 빨리 회수할 수 있도록 유도? (큰 객체 참조 시 유의미?)
        removeNode.item = null;
        removeNode.next = null;

        size--;
        return removeItem;
    }

    // 기존 값 반환
    public Object set(int index, Object element) {
        Node node = getNode(index);

        Object oldValue = node.item;
        node.item = element;

        return oldValue;
    }

    public Object get(int index) {
        return getNode(index).item;
    }

    private Node getNode(int index) {
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int indexOf(Object element) {

        int index = 0;
        for (Node node = first; node != null; node = node.next) {
            if (element.equals(node.item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    private Node getLastNode() {
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
}
