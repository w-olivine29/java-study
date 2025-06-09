package ch27collection.section3list.sub2performance.mylist;

public class MyLinkedList<E> implements MyList<E> {

    private Node<E> first;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        if (size == 0) {
            first = newNode;
        } else {
            Node<E> lastNode = getLastNode();
            lastNode.next = newNode;
        }

        size++;
    }

    @Override
    public void add(int index, E e) {
        Node<E> newNode = new Node<>(e);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        }
        Node<E> prev = getNode(index);
        newNode.next = prev.next;
        prev.next = newNode;

        size++;
    }

    @Override
    public E set(int index, E e) {
        Node<E> oldNode = getNode(index);
        E oldValue = oldNode.item;
        oldNode.item = e;

        return oldValue;
    }

    @Override
    public E remove(int index, E e) {
        Node<E> prev = getNode(index - 1);
        Node<E> removedNode = getNode(index);

        prev.next = removedNode.next;

        size--;
        return removedNode.item;
    }

    @Override
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

    private Node<E> getLastNode() {
        return getNode(size - 1);
    }

    @Override
    public int indexOf(E e) {

        int index = 0;
        for (Node<E> node = first; node != null; node = node.next) {
            if (node.item.equals(e)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
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
    }
}
