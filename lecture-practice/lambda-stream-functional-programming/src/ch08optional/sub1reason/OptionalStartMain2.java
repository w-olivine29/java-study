package ch08optional.sub1reason;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalStartMain2 {
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

        //Optional<String> optionalName = findNameById(id);
        System.out.println(id + ": " + findNameById(id).orElse("UNKNOWN").toUpperCase());
    }

    static Optional<String> findNameById(Long id) {
        String findName =  map.get(id);

        // 값을 감싸고 있는 컨테이너 객체라고 보면 된다.
        // 해당 메서드를 호출하는 입장에서 반환받는 값이 null일 수도 있다는 것을 명시적으로 알 수 있음
        // 놓치기 쉬운 null 체크를 강제한다
        return Optional.ofNullable(findName);
    }
}
