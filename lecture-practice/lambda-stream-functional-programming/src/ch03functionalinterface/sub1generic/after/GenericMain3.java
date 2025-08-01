package ch03functionalinterface.sub1generic.after;

public class GenericMain3 {
    public static void main(String[] args) {

        GenericFunction<String, String> upperCase = str -> str.toUpperCase();
        String result1 = upperCase.apply("welcome");
        System.out.println("result1 = " + result1);


        GenericFunction<Integer, Integer> square = n -> n * n;
        Integer result2 = square.apply(5);
        System.out.println("result2 = " + result2);
    }


    @FunctionalInterface
    interface GenericFunction<T, R> {
        R apply(T value);
    }

}