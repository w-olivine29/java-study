package annotation.general.deprecated;

public class OldLibrary {

    // @Deprecated 는 자바 애노테이션으로, "이 메서드는 앞으로 사라질 예정이니 사용하지 말라"는 뜻.
    // 기능은 여전히 동작하지만, 추후 버전에서 제거될 수 있음
    
    // 실무에서는 주로 'Fade-out 전략' 적용 (언어 차원의 개념 x, 관리 방법)
    // 이는 기능을 단계적으로 축소·대체하여 최종적으로 삭제하는 과정 (Deprecated → 제거까지 이어지는 전 과정을 포괄)
    @Deprecated
    public void printMessage() {
        System.out.println("OldLibrary.printMessage");
    }
}
