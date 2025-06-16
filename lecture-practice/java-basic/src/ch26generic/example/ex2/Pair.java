package ch26generic.example.ex2;

public class Pair<T1, T2> {

    private T1 first;
    private T2 second;

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public void setFirst(T1 value) {
        first = value;
    }

    public void setSecond(T2 value) {
        second = value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}

