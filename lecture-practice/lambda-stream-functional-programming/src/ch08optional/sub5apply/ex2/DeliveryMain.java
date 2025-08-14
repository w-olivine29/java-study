package ch08optional.sub5apply.ex2;

import ch08optional.sub5apply.ex2.model.Delivery;
import ch08optional.sub5apply.ex2.model.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DeliveryMain {
    static Map<Long, Order> orderRepository = new HashMap<>();

    // Static 블록은 클래스가 JVM에 로드될 때 딱 한 번만 실행되는 코드 블록
    static {
        orderRepository.put(1L, new Order(1L, new Delivery("배송완료", false)));
        orderRepository.put(2L, new Order(2L, new Delivery("배송중", false)));
        orderRepository.put(3L, new Order(3L, new Delivery("배송중", true)));
        orderRepository.put(4L, new Order(4L, null));
    }

    public static void main(String[] args) {
        System.out.println("1 = " + getDeliveryStatus(1L));
        System.out.println("2 = " + getDeliveryStatus(2L));
        System.out.println("3 = " + getDeliveryStatus(3L));
        System.out.println("4 = " + getDeliveryStatus(4L));
    }

    private static String getDeliveryStatus(long orderId) {
        return findOrder(orderId)
                .map(Order::getDelivery)
                .filter(delivery -> !delivery.isCanceled()) // 취소되지 않은 배송정보여야함
                .map(Delivery::getStatus) // delivery -> String
                .orElse("배송 x"); // 값이 없으면 "배송 x" 반환
    }

    private static Optional<Order> findOrder(long orderId) {
        return Optional.ofNullable(orderRepository.get(orderId));
    }
}
