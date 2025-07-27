package ch01lambda.sub1whylambda.step3startlambda;

import ch01lambda.MyFunction;

public class MyFunctionMain {
    public static void main(String[] args) {

        MyFunction myFunction1 = new MyFunction() {
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        };

        int result = myFunction1.apply(1, 2);
        System.out.println("result = " + result);

//===============================================================

        MyFunction myFunction2 = (int a, int b) -> {
            return a + b;
        };

        // 해당 코드는 (int a, int b) ->  a + b; 로도 표현 가능
        // IDE가 추천해주는 코드 ->  Integer::sum

        myFunction2.apply(1, 2);
        System.out.println("myFunction2 = " + myFunction2);
    }
}
