package ch27collection.section7map.example.ex7;

import java.util.Map;

public class Cart_MySolution {

    private Map<Product, Integer> cart;


    public Cart_MySolution(Map<Product, Integer> cart) {
        this.cart = cart;
    }

    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    public void addProduct(Product product, int quantity) {
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    public void minusQuantity(Product product) {
        minusQuantity(product, 1);
    }

    public void minusQuantity(Product product, int quantity) {

        if (!cart.containsKey(product)) {
            System.out.println("장바구니에 존재하지않는 상품입니다.");
            return;
        }

        if (cart.get(product) < quantity) {
            System.out.println("잘못된 수량 요청");
            return;
        }

        cart.put(product, cart.getOrDefault(product, 0) - quantity);

        if (cart.get(product) <= 0) {
            cart.remove(product);
        }
    }

    public void showItems() {
        System.out.println("== 장바구니 상품 출력 ==");
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            System.out.printf("상품: %s, 수량: %d, 총 가격: %d\n",
                    product.getName(), entry.getValue(), (product.getPrice() * entry.getValue()));
        }
    }
}
