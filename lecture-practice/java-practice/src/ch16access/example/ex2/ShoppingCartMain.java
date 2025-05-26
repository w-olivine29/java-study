package ch16access.example.ex2;

/* 쇼핑카트
- Item, ShoppingCart 클래스 만들기
    - 데이터 캡슐화
    - 해당 클래스는 다른 패키지에서도 사용가능해야함
    - 장바구니에는 최대 5까지만 담을 수 있다.
- 장바구니 상품 출력
    - 상품명, 개수, 합계, 전체가격
* */
public class ShoppingCartMain {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItem(new Item("헤드폰",30000),1);
        shoppingCart.addItem(new Item("이어폰",15000),2);
        shoppingCart.addItem(new Item("머리끈",500),10);
        shoppingCart.addItem(new Item("휴대폰",900_000),1);
        shoppingCart.showItems();

    }


}
