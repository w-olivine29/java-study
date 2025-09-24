package ch02annotation.general.suppresswarning;

import java.util.ArrayList;
import java.util.List;

public class SuppressWarningExample {

    /*
     * @SuppressWarnings는 컴파일러/IDE 경고를 억제하는 애노테이션
     * unchecked, rawtypes, unused 등 특정 경고 코드를 선택적으로 무시 가능
     *
     * 그러나 이는 경고가 알려주는 잠재적 버그 가능성을 강제로 덮는 것이므로
     * 가급적 사용을 지양하고, 경고가 발생하지 않는 방향으로 코드를 개선하는 것이 바람직
     *
     * 실무에서는 레거시 코드 수정 시 사이드 이펙트를 피하기 어렵거나,
     * 리플렉션/구버전 라이브러리와 호환해야 하는 경우에 한정적으로 사용
     */
    @SuppressWarnings({"unchecked", "rawtypes", "unused"})
    public class SuppressWarningsExample {
        public void something() {
            List list = new ArrayList();
            list.add("data");
            System.out.println(list.getFirst());
        }
    }
}
