package ch21lang.section2immutable.step3immutable.ex3.after;

public class ImmutableMain {
    public static void main(String[] args) {
        ImmutableObj obj1 = new ImmutableObj(20);
        ImmutableObj obj2 = obj1.add(20);

        // 계산이후에도 기존 obj1의 값은 변하지 않음
        System.out.println("obj1 = " + obj1.getValue()); //20
        System.out.println("obj2 = " + obj2.getValue()); //40

    }
}
