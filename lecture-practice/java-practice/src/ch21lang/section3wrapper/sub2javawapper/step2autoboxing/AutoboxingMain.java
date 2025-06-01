package ch21lang.section3wrapper.sub2javawapper.step2autoboxing;

public class AutoboxingMain {
    public static void main(String[] args) {

        // 컴파일러가 자동으로 valueOf, xxxValue() 등의 코드를 추가해준다. (오토박싱, 오토언박싱)

        // Primitive -> Wrapper
        int value = 10;
        Integer boxedValue = value;  //오토 박싱

        // Wrapper -> Primitive
        int unboxedValue = boxedValue; //오토 언박싱

        System.out.println("boxedValue = " + boxedValue);
        System.out.println("unboxedValue = " + unboxedValue);
    }
}
