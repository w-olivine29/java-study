package ch09defaultmethod.ex.step3;

import java.time.LocalDateTime;

// 자세한 내용은 pdf 참고 필수
public interface NotifierV3 {

    // 알림을 보내는 기능
    void notify(String message);

    // 새로운 기능 추가 -> 구현 클래스들이 강제로 해당 메서드를 추가 구현하도록 요구
    // 실무환경에서 해당 인터페이스를 구현한 클래스가 수십 수백개라면...? OMG...
    //void scheduleNotification(String message, LocalDateTime scheduleTime);


    // 새로운 기능을 default 메서드로 추가
    // 디폴트 메서드는 어디까지나 하위 호환을 위한 기능
    // 공통으로 쓰기 쉬운 간단한 로직을 제공하는 정도가 이상적
    default void scheduleNotification(String message, LocalDateTime scheduleTime){
        System.out.printf("[기본 스케줄링] message: %s, time: %s", message, scheduleTime);
    }
}
