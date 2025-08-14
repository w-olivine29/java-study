package ch09defaultmethod.ex.step3;

import java.time.LocalDateTime;

public class AppPushNotifierV3 implements NotifierV3 {
    @Override
    public void notify(String message) {
        System.out.println("[App] " + message);
    }

    // default 메서드의 경우 구현 강제x
    // 그러나 인터페이스 다중 구현할 경우 동일 시그니처의 디폴트 메서드 존재 시 충돌 -> 구현 강제
}
