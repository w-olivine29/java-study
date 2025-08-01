package ch03functionalinterface.sub1generic.before;

public class GenericMain2_Object {
    public static void main(String[] args) {

        ObjectFunction upperCase = value -> {
            String str = (String) value;
            return str.toUpperCase();
        };
        String result1 = (String) upperCase.apply("welcome");
        System.out.println("result1 = " + result1);


        ObjectFunction square = n -> {
            int num = (int) n;
            return num * num;
        };
        Integer result2 = (Integer) square.apply(5);
        System.out.println("result2 = " + result2);
    }


    @FunctionalInterface
    interface ObjectFunction {
        Object apply(Object value);
    }

}