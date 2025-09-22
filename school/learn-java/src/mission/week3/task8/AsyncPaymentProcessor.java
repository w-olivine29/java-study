package mission.week3.task8;


import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

// 41기 유도경
public class AsyncPaymentProcessor {
    public static void main(String[] args) {

        //ExecutorService es = Executors.newFixedThreadPool(2);
        //ExecutorService es = Executors.newFixedThreadPool(9);
        ExecutorService es = Executors.newCachedThreadPool();


        // 대기 요청이 있다고 가정
        List<PayRequest> waitingRequests = List.of(
                new PayRequest("0번", 1000),
                new PayRequest("1번", 2000),
                new PayRequest("2번", 3000),
                new PayRequest("3번", 4000),
                new PayRequest("4번", 5000),
                new PayRequest("5번", 6000),
                new PayRequest("6번", 7000),
                new PayRequest("7번", 8000),
                new PayRequest("8번", 9000),
                new PayRequest("9번", 10000)
        );

        try {
            // 짝수번째면 정상실행, 홀수번째면 실패로 가정
            for (int i = 0; i < waitingRequests.size(); i++) {

                PayRequest request = waitingRequests.get(i);
                Supplier<PayResponse> supplier = (i % 2 == 0) ? requestPaySuccess(request) : requestPayFail(request);

                CompletableFuture.supplyAsync(supplier, es)
                        .orTimeout(3000, TimeUnit.MILLISECONDS) // TimeoutException 발생
                        .exceptionally(exception -> new PayResponse(request.getId(), 0, false)
                        ).thenAccept(AsyncPaymentProcessor::printResult);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            es.shutdown();
        }

    }

    private static Supplier<PayResponse> requestPaySuccess(PayRequest request) {
        return () -> {
            System.out.printf("[%s] 결제 요청 중... (결제금액: %d) - [%s]\n",
                    request.getId(), request.getPayAmount(), Thread.currentThread().getName());

            return new PayResponse(request, true);
        };
    }

    private static Supplier<PayResponse> requestPayFail(PayRequest request) {
        return () -> {
            System.out.printf("[%s] 결제 요청 중... (결제금액: %d) - [%s]\n",
                    request.getId(), request.getPayAmount(), Thread.currentThread().getName());

            // 실패상황 가정
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }

            return new PayResponse(request, true);
        };
    }

    private static void printResult(PayResponse response) {
        if (response.isSuccess()) {
            System.out.printf("[%s] 결제 완료: %d원 - [%s] - [%s] \n",
                    response.getId(), response.getPayAmount(), Thread.currentThread().getName(), Thread.currentThread().getName());
        } else {
            System.out.printf("[%s] 결제 실패 (시간초과)\n", response.getId());
        }
    }

}

class PayRequest {
    private String id;
    private int payAmount;

    public PayRequest(String id, int payAmount) {
        this.id = id;
        this.payAmount = payAmount;
    }

    public String getId() {
        return id;
    }

    public int getPayAmount() {
        return payAmount;
    }
}

class PayResponse {
    private String id;
    private Integer payAmount;
    private boolean isSuccess;

    public PayResponse(PayRequest request, boolean isSuccess) {
        this.id = request.getId();
        this.payAmount = request.getPayAmount();
        this.isSuccess = isSuccess;
    }

    public PayResponse(String id, Integer payAmount, boolean isSuccess) {
        this.id = id;
        this.payAmount = payAmount;
        this.isSuccess = isSuccess;
    }

    public String getId() {
        return id;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}


/* newFixedThreadPool(2) 설정

main 스레드에서 CompletableFuture.supplyAsync() 를 생성 -> 바로 orTimeOut() 작동시작 (작업이 스레드에서 실행되기를 기다리지 않는다)
작업은 제출 됐지만, 스레드가 할당되지 못하면 대기상태 (타이머는 계속 흘러감)
스레드가 할당 or 완료 전에 타이머 만료 -> TimeoutException 발생

[0번] 결제 요청 중... (결제금액: 1000) - [pool-1-thread-1]
[1번] 결제 요청 중... (결제금액: 2000) - [pool-1-thread-2]
[0번] 결제 완료: 1000원 - [pool-1-thread-1] - [pool-1-thread-1]
[2번] 결제 요청 중... (결제금액: 3000) - [pool-1-thread-1]
[2번] 결제 완료: 3000원 - [pool-1-thread-1] - [pool-1-thread-1]
[3번] 결제 요청 중... (결제금액: 4000) - [pool-1-thread-1]
[1번] 결제 실패 (시간초과)
[3번] 결제 실패 (시간초과)
[4번] 결제 실패 (시간초과)
[5번] 결제 실패 (시간초과)
[6번] 결제 실패 (시간초과)
[7번] 결제 실패 (시간초과)
[8번] 결제 실패 (시간초과)
[9번] 결제 실패 (시간초과)
*/


/* 풀을 요청 개수대로 맞추면 의도한 대로 동작

[0번] 결제 요청 중... (결제금액: 1000) - [pool-1-thread-1]
[1번] 결제 요청 중... (결제금액: 2000) - [pool-1-thread-2]
[2번] 결제 요청 중... (결제금액: 3000) - [pool-1-thread-3]
[3번] 결제 요청 중... (결제금액: 4000) - [pool-1-thread-4]
[4번] 결제 요청 중... (결제금액: 5000) - [pool-1-thread-5]
[5번] 결제 요청 중... (결제금액: 6000) - [pool-1-thread-6]
[6번] 결제 요청 중... (결제금액: 7000) - [pool-1-thread-7]
[6번] 결제 완료: 7000원 - [pool-1-thread-7] - [pool-1-thread-7]
[7번] 결제 요청 중... (결제금액: 8000) - [pool-1-thread-8]
[8번] 결제 요청 중... (결제금액: 9000) - [pool-1-thread-9]
[8번] 결제 완료: 9000원 - [pool-1-thread-9] - [pool-1-thread-9]
[9번] 결제 요청 중... (결제금액: 10000) - [pool-1-thread-10]
[0번] 결제 완료: 1000원 - [pool-1-thread-1] - [pool-1-thread-1]
[2번] 결제 완료: 3000원 - [pool-1-thread-3] - [pool-1-thread-3]
[4번] 결제 완료: 5000원 - [pool-1-thread-5] - [pool-1-thread-5]
[1번] 결제 실패 (시간초과)
[3번] 결제 실패 (시간초과)
[5번] 결제 실패 (시간초과)
[7번] 결제 실패 (시간초과)
[9번] 결제 실패 (시간초과)
*/