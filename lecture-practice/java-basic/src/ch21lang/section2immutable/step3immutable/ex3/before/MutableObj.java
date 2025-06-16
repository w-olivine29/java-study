package ch21lang.section2immutable.step3immutable.ex3.before;

public class MutableObj {

    private int value;

    public MutableObj(int value) {
        this.value = value;
    }

    // 계산 이후 기존 값은 사라짐
    public void add(int addValue) {
        value += addValue;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
