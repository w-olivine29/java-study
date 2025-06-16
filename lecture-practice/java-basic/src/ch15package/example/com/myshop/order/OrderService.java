package ch15package.example.com.myshop.order;

import ch15package.example.com.myshop.product.Product;
import ch15package.example.com.myshop.user.User;

public class OrderService {

    public void order() {
        User user = new User(1L, "user1", "유저1");
        Product product = new Product(1L, "헤어토닉", 20000);
        Order order = new Order(1L, user, product);
    }
}
