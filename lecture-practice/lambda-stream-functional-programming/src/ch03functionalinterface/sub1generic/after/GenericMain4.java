package ch03functionalinterface.sub1generic.after;

public class GenericMain4 {
    public static void main(String[] args) {

        GenericFunction<String, String> upperCase = str -> str.toUpperCase();
        GenericFunction<String, Integer> stringLength = str -> str.length();

        GenericFunction<Integer, Integer> square = n -> n * n;
        GenericFunction<Integer, Boolean> isEven = n -> n % 2 == 0;

        System.out.println("upperCase.apply(\"welcome\") = " + upperCase.apply("welcome"));
        System.out.println("stringLength.apply(\"welcome\") = " + stringLength.apply("welcome"));
        System.out.println("square.apply(5) = " + square.apply(5));
        System.out.println("isEven.apply(5) = " + isEven.apply(5));
    }


    @FunctionalInterface
    interface GenericFunction<T, R> {
        R apply(T value);
    }

}