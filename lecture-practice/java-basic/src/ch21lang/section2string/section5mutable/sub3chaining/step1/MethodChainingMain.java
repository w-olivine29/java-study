package ch21lang.section2string.section5mutable.sub3chaining.step1;

public class MethodChainingMain {
    public static void main(String[] args) {

        ValueAdder adder = new ValueAdder();
        adder.add(1);
        adder.add(1);
        adder.add(1);
        adder.add(1);
        adder.add(1);
        System.out.println("adder.value = " + adder.getValue()); //5


        // add 호출 시 값변경후 this 참조값 반환 -> 반환된 참조값으로 바로 메서드 호출 -> 반복
        adder = new ValueAdder();
        ValueAdder adder1 = adder.add(1);
        ValueAdder adder2 = adder1.add(1);
        ValueAdder adder3 = adder2.add(1);
        ValueAdder adder4 = adder3.add(1);
        ValueAdder adder5 = adder4.add(1);
        System.out.println("adder.value = " + adder.getValue()); //5
        System.out.println("adder.value = " + adder5.getValue()); //5

        adder = new ValueAdder();

        // 메서드 체이닝 기법 (코드가 간결해짐)
        int result = adder.add(1).add(1).add(1).add(1).add(1).getValue();
        System.out.println("result = " + result);
    }
}
