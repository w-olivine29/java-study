package ch27collection.section7map.example.ex4;

import java.util.HashMap;
import java.util.Map;

/* 값으로 검색

Map에 들어있는 데이터 중에 값이 10000원 이하인 모든 상품을 출력
*/
public class ItemPrice_MySolution {
    public static void main(String[] args) {

        Map<String, Integer> menuMap = new HashMap<>();

        menuMap.put("Shrimp Rose Pasta", 9900);
        menuMap.put("Triple Mushroom Cream Pasta", 8900);
        menuMap.put("Hot Spicy Bacon Cream Pasta", 8900);
        menuMap.put("Tomato Ragu Eggplant Pasta", 8900);
        menuMap.put("Vongole Pasta", 8900);
        menuMap.put("Shrimp Aglio e Olio", 9900);
        menuMap.put("Ricotta Cheese & Baguette Salad", 10000);
        menuMap.put("New York Strip Steak", 47900);
        menuMap.put("Barbecue Don Mahawk Steak", 24900);
        menuMap.put("Truffle Oil French Fries", 8000);
        menuMap.put("Green Salad", 6000);
        menuMap.put("House Wine", 6000);

        Map<String, Integer> belowPriceMenuMap = getBelowPriceMenu(menuMap, 10000);
        printMenuMap(belowPriceMenuMap);

    }

    private static Map<String, Integer> getBelowPriceMenu(
            Map<String, Integer> menuMap, int price) {

        HashMap<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> menu : menuMap.entrySet()) {
            if (menu.getValue() <= price) {
                result.put(menu.getKey(), menu.getValue());
            }
        }
        return result;
    }

    private static <K, V> void printMenuMap(Map<K, V> menuMap) {
        for (Map.Entry<K, V> entry : menuMap.entrySet()) {
            System.out.println(entry);
        }
    }
}
