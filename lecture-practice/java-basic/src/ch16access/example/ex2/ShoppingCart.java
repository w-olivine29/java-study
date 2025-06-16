package ch16access.example.ex2;

/*
- Item, ShoppingCart 클래스 만들기
    - 데이터 캡슐화
    - 해당 클래스는 다른 패키지에서도 사용가능해야함
    - 장바구니에는 최대 10까지만 담을 수 있다.
- 장바구니 상품 출력
    - 상품명, 개수, 합계, 전체가격
    */
public class ShoppingCart {

    private CartItem[] items;
    private int maxCnt = 5;
    private int currentCnt;

    public ShoppingCart() {
        items = new CartItem[maxCnt];
        currentCnt = 0; // 생략 가능
    }

    public void addItem(Item item, int quantity) {
        if (maxCnt <= currentCnt) {
            System.out.println("장바구니가 가득 찼습니다.");
            return;
        }
        items[++currentCnt - 1] = new CartItem(item, quantity);
    }


    // 해설 전에 풀이한 것과, 총액 계산 메서드 분리 전 코드들은 주석처리
    public void showItems() {
        System.out.println("===== 장바구니 =====");

        //int totalAmount = 0;

//        for (CartItem cartItem : items) {
//            if (cartItem != null) {
//                String itemName = cartItem.getItem().getName();
//                int price = cartItem.getItem().getPrice();
//                int quantity = cartItem.getQuantity();
//                int amount = cartItem.getAmount();
//
//                totalAmount += amount;
//                System.out.printf("상품명: %s, 상품가격: %d, 상품개수: %d, 합계: %d\n",
//                        itemName, price, quantity, amount);
//            }
//        }

        for (int i = 0; i < currentCnt; i++) {
            Item item = items[i].getItem();
            int amount = items[i].getAmount();

            //totalAmount += amount;
            System.out.printf("상품명: %s, 상품가격: %d, 상품개수: %d, 합계: %d\n",
                    item.getName(), item.getPrice(), items[i].getQuantity(), amount);
        }

        //System.out.print("전체 가격: " + totalAmount);
        System.out.print("전체 가격: " + calculateToTalPrice());
    }

    private int calculateToTalPrice() {
        int totalAmount = 0;

        for (int i = 0; i < currentCnt; i++) {
            Item item = items[i].getItem();
            int amount = items[i].getAmount();

            totalAmount += amount;
        }
        return totalAmount;
    }

}
