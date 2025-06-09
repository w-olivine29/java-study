package ch27collection.section3list.sub1abstract.step1interface;

public interface MyList<E> {

    int size();

    void add(E e);

    void add(int index, E e);

    E set(int index, E e);

    E remove(int index, E e);

    E get(int index);

    int indexOf(E e);

}
