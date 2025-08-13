package ch08optional.sub1reason;

import java.util.HashMap;
import java.util.Map;

public class OptionalStartMain {
    private static final Map<Long, String> map = new HashMap<>();

    // static{}: 애플리케이션에서 처음 로딩될 때 호출이 되는 블럭
    static {
        map.put(1L, "Cheddar");
        map.put(2L, "Mozzarella");
    }

    public static void main(String[] args) {
        findAndPrint(1L); // 값이 있는 경우
        findAndPrint(3L); // 값이 없는 경우
    }

    // 이름이 있다면 이름을 대문자로 출력, 없으면 "UNKNOWN" 출력
    static void findAndPrint(Long id) {
        String name = findNameById(id); // null 반환 가능성있음

        // name이 null 값인 상태에서 메서드 호출 시 NullPointerException 발생
        //System.out.println("name = " + name.toUpperCase());

        //if 문을 활용한 null 체크 활용
        if (name != null) {
            System.out.println(id + ": " + name.toUpperCase());
        } else {
            System.out.println(id + ": " + "UNKNOWN");
        }
    }

    static String findNameById(Long id) {
        return map.get(id);
    }
}
