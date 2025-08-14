package ch09defaultmethod.ex.step2;

import java.time.LocalDateTime;

public class AppPushNotifierV2 implements NotifierV2 {
    @Override
    public void notify(String message) {
        System.out.println("[App] " + message);
    }

    
    // 새로 추가된 메서드 구현 강제
    @Override
    public void scheduleNotification(String message, LocalDateTime scheduleTime) {
        System.out.printf("[App 전용 스케줄링] message: %s, time: %s", message, scheduleTime);
    }
}
