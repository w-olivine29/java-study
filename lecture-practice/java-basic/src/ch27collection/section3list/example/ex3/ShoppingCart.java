package ch27collection.section3list.example.ex3;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Item> cart;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
    }

    public void addItem(Item item) {
        cart.add(item);
    }

    public int totalPrice() {
        int sum = 0;
        for (Item item : cart) {
            sum += item.getTotalPrice();
        }
        return sum;
    }

    public void displayItems() {
        System.out.println("장바구니 상품 출력");
        for (Item item : cart) {
            System.out.printf("상품명: %s, 합계: %d\n",
                    item.getName(), item.getTotalPrice());
        }
        System.out.println("전체 가격 합: " + totalPrice());
    }
}
