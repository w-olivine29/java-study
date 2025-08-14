package ch09defaultmethod.ex.step3;

import java.util.List;

public class NotifierMainV3 {
    public static void main(String[] args) {
        List<NotifierV3> notifierV3s = List.of(new EmailNotifierV3(), new SMSNotifierV3(), new AppPushNotifierV3());

        notifierV3s.forEach(notifierV3 -> notifierV3.notify("welcome"));
    }
}
