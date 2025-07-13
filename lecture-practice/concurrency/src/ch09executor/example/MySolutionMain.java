package ch09executor.example;

import java.util.concurrent.Executors;

public class MySolutionMain {
    public static void main(String[] args) {
        OrderService_MySolution orderService =
                new OrderService_MySolution(Executors.newFixedThreadPool(3));

        try(orderService){
            orderService.order("Order#1234");
        }

    }

}
