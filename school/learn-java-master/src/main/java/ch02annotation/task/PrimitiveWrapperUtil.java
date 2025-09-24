package ch02annotation.task;

import java.util.Map;

// 41기 유도경
public class PrimitiveWrapperUtil {
    private static final Map<Class<?>, Class<?>> primitiveWrapperMap = Map.ofEntries(
            Map.entry(byte.class, Byte.class),
            Map.entry(short.class, Short.class),
            Map.entry(int.class, Integer.class),
            Map.entry(long.class, Long.class),
            Map.entry(float.class, Float.class),
            Map.entry(double.class, Double.class),
            Map.entry(boolean.class, Boolean.class),
            Map.entry(char.class, Character.class)
    );

    public static Class<?> wrap(Class<?> type) {
        return primitiveWrapperMap.getOrDefault(type, type);
    }
}
