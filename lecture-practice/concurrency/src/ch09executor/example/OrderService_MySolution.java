package ch09executor.example;

import java.util.List;
import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

// OldOrderService 는 모든 작업이 단일 스레드 처럼 동기적으로 실행
// 기존의 순차 처리를 멀티스레드 병렬 처리로 개선 (처리 시간 단축)
public class OrderService_MySolution implements AutoCloseable {

    private final ExecutorService es;

    public OrderService_MySolution(ExecutorService es) {
        this.es = es;
    }

    public void order(String orderNumber) {

        try{
            List<Callable<Boolean>> tasks = List.of(
                    new InventoryWork(orderNumber),
                    new ShippingWork(orderNumber),
                    new AccountingWork(orderNumber));

            // 블로킹
            List<Future<Boolean>> futures = es.invokeAll(tasks);

            // 이 시점에는 작업들이 모두 끝난상태
            for (Future<Boolean> future : futures) {
                future.get(); // 실패한 작업은 여기서 예외 발생
            }
            log("모든 주문 처리 완료");

        } catch (Exception e) {
            log("일부 작업 실패");
            log(e.getCause());
        }
    }

    @Override
    public void close(){
        es.close();
    }


    static class InventoryWork implements Callable<Boolean> {

        private final String orderNo;

        public InventoryWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() {
            log("재고 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }

    static class ShippingWork implements Callable<Boolean> {

        private final String orderNo;

        public ShippingWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() {
            log("배송 시스템 알림: " + orderNo);
            sleep(1000);
            return true;
        }
    }

    static class AccountingWork implements Callable<Boolean> {

        private final String orderNo;

        public AccountingWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() {
            log("회계 시스템 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }

}
