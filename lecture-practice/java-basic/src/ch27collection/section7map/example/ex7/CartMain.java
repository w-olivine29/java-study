package ch27collection.section7map.example.ex7;

import java.util.HashMap;

/* 장바구니

- 장바구니 추가
  - 장바구니에 상품과 수량 담기
    - 상품의 이름과 가격이 같다면 같은 상품
    - 이름과 가격이 같은 상품을 추가 시 -> 수량만 추가
    - 이름과 가격이 다른 상품 추가시 새로운 상품 추가
- 장바구니 제거
  - 장바구니에 담김 상품의 수량 줄이기 
    - 수량이 0보다 작다면 장바구니에서 제거

해당코드를 참고하여, Product, Cart 클래스 구현
*/
public class CartMain {
    public static void main(String[] args) {

        Cart_MySolution cartMySolution = new Cart_MySolution(new HashMap<>());
        cartMySolution.addProduct(new Product("Monster Energy Ultra", 2000));
        cartMySolution.addProduct(new Product("Monster Energy Ultra", 2000));
        cartMySolution.addProduct(new Product("Monster Energy Zero Sugar", 2000));
        cartMySolution.addProduct(new Product("Monster Energy Ultra", 2000));
        cartMySolution.addProduct(new Product("TaeYang Digestion W", 1500), 24);

        cartMySolution.showItems();

        cartMySolution.minusQuantity(new Product("Monster Energy Zero Sugar", 2000));
        cartMySolution.minusQuantity(new Product("TaeYang Digestion W", 1500), 3);
        cartMySolution.minusQuantity(new Product("Monster Energy Ultra", 2000), 5);

        cartMySolution.showItems();
    }

}
