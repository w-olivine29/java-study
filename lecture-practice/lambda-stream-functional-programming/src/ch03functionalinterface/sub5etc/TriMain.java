package ch03functionalinterface.sub5etc;

// 삼항 인터페이스는 기본제공 x
public class TriMain {
    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> triFunction = (a, b, c) -> a + b + c;
        System.out.println("triFunction.apply(1,2,3) = " + triFunction.apply(1, 2, 3));
    }

    interface TriFunction<A, B, C, R> {
        R apply(A a, B b, C c);
    }
}
