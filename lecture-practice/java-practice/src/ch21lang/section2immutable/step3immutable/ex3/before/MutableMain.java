package ch21lang.section2immutable.step3immutable.ex3.before;

public class MutableMain {
    public static void main(String[] args) {
        MutableObj obj = new MutableObj(10);
        obj.add(30);


        System.out.println("obj = " + obj.getValue()); //40
    }
}
