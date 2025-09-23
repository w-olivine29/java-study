package annotation.general.safevarargs;

public class SafeVarargsExample {
    
    
    // 제네릭 가변인자에 대한 경고 무시
    // 해당 주석 제거 시 Possible heap pollution from parameterized vararg type 경고 안내

    // @SafeVarargs는 제네릭 가변인자에서 발생하는 경고를 억제하는 효과
    // 단, 개발자가 해당 메서드가 실제로 타입 안전함을 보장해야 함
    // 잘못 사용하면 런타임 오류 위험이 있으므로 남용은 지양
    @SafeVarargs
    public static <T> void printMessage(T... messages) {
        for (T message : messages) {
            System.out.println(message);
        }
    }
}
