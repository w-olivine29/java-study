package ch21lang.section3wrapper.sub2javawapper.step2autoboxing;

public class ManualboxingMain {
    public static void main(String[] args) {

        // Primitive -> Wrapper (수동 박싱)
        int value = 10;
        Integer boxedValue = Integer.valueOf(value);

        // Wrapper -> Primitive (수동 언박싱)
        int unboxedValue = boxedValue.intValue();

        System.out.println("boxedValue = " + boxedValue);
        System.out.println("unboxedValue = " + unboxedValue);
    }
}
