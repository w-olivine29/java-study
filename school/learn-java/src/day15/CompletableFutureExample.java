package day15;

import java.util.concurrent.CompletableFuture;

/*
supplyAsync() 와 thenApply() 를 활용하는 프로그램 작성
    - supplyAsync() 를 활용하여 숫자 10 반환
    - thenApply()를 활용하여 두 배로 증가하는 코드 작성
    - thenApply()를 활용하여 5를 더하는 코드를 작성
*/
public class CompletableFutureExample {
    public static void main(String[] args) {

        CompletableFuture.supplyAsync(() -> {  //Supplier<U> supplier
            System.out.println("숫자 생성 중..");
            return 10;
        }).thenApply(num -> { //Supplier<U> supplier
            System.out.printf("%d * 2 = %d\n", num, num * 2);
            return num * 2;

        }).thenApply(num -> { //Supplier<U> supplier
            System.out.printf("%d + 5 = %d\n", num, num + 5);
            return num + 5;
        }).thenAccept(result -> System.out.println("result = " + result));


        // main 스레드 대기 (대기하지않으면 숫자 생성 중만 출력하고 자바 종료)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}
