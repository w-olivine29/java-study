package ch03functionalinterface.sub1generic.before;

public class GenericMain1 {
    public static void main(String[] args) {

        StringFunction upperCase = s -> s.toUpperCase();
        String result1 = upperCase.apply("welcome");
        System.out.println("result1 = " + result1);

        NumberFunction square = n -> n * n;
        Integer result2 = square.apply(5);
        System.out.println("result2 = " + result2);
    }


    @FunctionalInterface
    interface StringFunction {
        String apply(String value);
    }

    @FunctionalInterface
    interface NumberFunction {
        Integer apply(Integer value);
    }
}