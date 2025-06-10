package ch27collection.section4hash.sub1start;


import java.util.Arrays;

public class MyHashSetV0 {

    private int[] elements = new int[10];
    private int size;

    //O(n+1) -> O(n)
    public boolean add(int value) {
        if (contains(value)) {
            return false;
        }
        elements[size++] = value;
        return true;
    }

    //O(n)
    public boolean contains(int value) {
        for (int element : elements) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }


    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyHashSetV0{" +
                "elements=" + Arrays.toString(Arrays.copyOf(elements, size)) + //빈값은 출력 x
                ", size=" + size +
                '}';
    }
}
