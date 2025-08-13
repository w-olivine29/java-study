package ch08optional.sub4lazyevaluation.step3optional;

import java.util.Optional;
import java.util.Random;

//
public class OrElseGetMain {
    public static void main(String[] args) {
        Optional<Integer> optValue = Optional.of(100);
        Optional<Integer> empty = Optional.empty();

        System.out.println("단순 계산");
        Integer result1 = optValue.orElse(10 + 20); // 10 + 20 연산 후 버려짐
        Integer emptyResult1 = empty.orElse(10 + 20); // 10 + 20 연산 후 사용

        System.out.println("result1 = " + result1);
        System.out.println("emptyResult1 = " + emptyResult1);
        

        // 값이 있으면 그 값, 없으면 지정된 기본값 사용
        System.out.println("\n=== orElse =================================================");
        System.out.println("[값이 있는 경우]");
        Integer result2 = optValue.orElse(createData()); // 3초 소모하면서 연산하고 버려짐
        System.out.println("result2 = " + result2);

        System.out.println("\n[값이 없는 경우]");
        Integer emptyResult2 = empty.orElse(createData()); // 3초 소모하면서 연산한 값 사용
        System.out.println("emptyResult2 = " + emptyResult2);

/*
        public T orElse(T other) {
            return value != null ? value : other;
        }
*/



        // 값이 있으면 그 값, 없으면 지정된 람다 사용
        System.out.println("\n=== orElseGet =================================================");
        System.out.println("[값이 있는 경우]");
        Integer result3 = optValue.orElseGet(() -> createData()); // 정의한 람다를 넘기고, 내부에서 람다 실행 x
        System.out.println("result3 = " + result3);

        System.out.println("\n[값이 없는 경우]");
        Integer emptyResult3 = empty.orElseGet(() -> createData()); // 정의한 람다를 넘기고, 내부에서 람다 실행 0
        System.out.println("emptyResult3 = " + emptyResult3);
        
/*        public T orElseGet(Supplier<? extends T> supplier) {
            return value != null ? value : supplier.get();
        }
*/

    }

    // 해당 데이터를 만드는 작업의 비용이 매우 크다고 가정
    static int createData() {
        System.out.println("데이터 생성 중........");

        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        int createValue = new Random().nextInt();
        System.out.println("데이터 생성 완료");

        return createValue;
    }
}

/*
넘길 값의 생성 비용이 크거나,
값이 들어있을 확률이 높아서 매번 대체값을 계산할 필요가 없는 경우에
orElseGet(Supplier<? extends T> supplier) 을 사용하도록 하자!

(단순값을 전달하거나 코드가 매우 간단하면 orElse() 사용)
*/