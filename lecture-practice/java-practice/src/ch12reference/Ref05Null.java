package ch12reference;

public class Ref05Null {
    public static void main(String[] args) {
        Data data = null; // "참조값이 없다" 라는 값이라고 보면된다. (참조형 변수에만 사용가능)
        System.out.println("1. data = " + data);

        data = new Data();
        System.out.println("2. data = " + data);

        data = null; // 앞서 만든 인스턴스의 주소를 더는 참조 X -> 참조했던 인스턴스는 JVM의 GC가 언제든 제거할 수 있는 상태가 됨
        System.out.println("3. data = " + data);
    }
}
