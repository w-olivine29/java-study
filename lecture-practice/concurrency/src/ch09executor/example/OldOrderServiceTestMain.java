package ch09executor.example;

public class OldOrderServiceTestMain {

    public static void main(String[] args) {
        String orderNo = "Order#1234";  // 예시 주문 번호
        OldOrderService orderService = new OldOrderService();
        orderService.order(orderNo);
    }

}