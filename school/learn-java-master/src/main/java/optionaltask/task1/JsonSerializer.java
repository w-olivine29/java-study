package optionaltask.task1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/* 과제 준수사항

- Reflection, Annotation 활용 진행 (Json 관련 라이브러리 사용금지)
- 속성이 문자열인 경우 따옴표 표시
*/

// 41기 유도경
public class JsonSerializer {

    public static String toJson(Object o) {

        Field[] fields = o.getClass().getDeclaredFields();

        List<String> entries = new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);
            getJsonEntry(field, o).ifPresent(entries::add);
        }

        // 반복문 안에서 마지막 인덱스 여부로 ',' 를 붙이면 skipYn 인 경우도 ',' 넣어버리게 되기때문에 적용된 값을 리스트로 모은 후에 한 번에 join 하였음
        return "{" + String.join(",", entries) + "}";
    }

    // 본래 convertToSnakeCase 로 지었으나, 변환하지 않는 상황도 있기때문에 resolve로 지었음
    private static Optional<String> getJsonEntry(Field field, Object o) {
        String key = resolveKey(field).orElse("");

        // 비어있다면 빈 옵셔널 그대로 반환
        if (key.isBlank()) {
            return Optional.empty();
        }

        Object value = null;
        try {
            value = field.get(o);

            String entry = (value instanceof String) ?
                    String.format("%s: \"%s\"", key, value) :
                    String.format("%s: %s", key, value);

            return Optional.of(entry);

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static Optional<String> resolveKey(Field field) {
        JsonField annotation = field.getAnnotation(JsonField.class);

        // 애노테이션이 아예 안 붙었으면, 변환 없이 그냥 그대로 반환
        if (annotation == null) {
            return Optional.of(field.getName());
        }

        if (annotation.skipYn()) {
            return Optional.empty();
        }

        // 값을 따로 안 넣었을 때 (직접 스네이크화)
        if (annotation.value().isEmpty()) {
            return Optional.of(convertToSnake(field.getName()));
        }

        // 값을 직접 지정해줬을 때는 해당 값 반환
        return Optional.of(annotation.value());
    }

    private static String convertToSnake(String word) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {

            if (Character.isUpperCase(word.charAt(i))) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(word.charAt(i)));
        }
        return sb.toString();
    }

}
