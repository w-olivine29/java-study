package ch15package.example.com.myshop.order;

import ch15package.example.com.myshop.product.Product;
import ch15package.example.com.myshop.user.User;

import java.time.LocalDateTime;

public class Order {
    long id;
    User user; // import
    Product product;   // import
    LocalDateTime orderedAt;

    public Order(long id, User user, Product product) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.orderedAt = LocalDateTime.now();
    }
}
