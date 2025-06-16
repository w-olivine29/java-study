package ch21lang.section2string.section5mutable.sub3chaining.step1;

//메서드 체이닝
public class ValueAdder {
    private int value;

    // 값을 변경시키고 자신의 참조값 반환
    public ValueAdder add(int addValue) {
        value += addValue;
        return this;
    }

    public int getValue() {
        return value;
    }
}
