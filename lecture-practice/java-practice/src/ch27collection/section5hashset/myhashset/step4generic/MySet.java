package ch27collection.section5hashset.myhashset.step4generic;

public interface MySet<E> {

    boolean add(E value);

    boolean remove(E value);

    boolean contains(E value);

    int size();
}
