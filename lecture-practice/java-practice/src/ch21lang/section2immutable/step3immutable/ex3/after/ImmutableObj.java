package ch21lang.section2immutable.step3immutable.ex3.after;

public class ImmutableObj {

    private final int value;

    public ImmutableObj(int value) {
        this.value = value;
    }

    // 원하는 값을 넣은 새로운 객체를 반환 (현재 본인의 필드값은 변하지않음)
    public ImmutableObj add(int addValue) {
        return new ImmutableObj(value + addValue);
    }

    public int getValue() {
        return value;
    }
}
