package ch09defaultmethod.ex.step2;

import java.time.LocalDateTime;

public interface NotifierV2 {

    // 알림을 보내는 기능
    void notify(String message);

    // 새로운 기능 추가 -> 구현 클래스들이 강제로 해당 메서드를 추가 구현하도록 요구
    // 실무환경에서 해당 인터페이스를 구현한 클래스가 수십 수백개라면...? OMG...
    void scheduleNotification(String message, LocalDateTime scheduleTime);

}
