package ch09defaultmethod.ex.step2;

import java.util.List;

public class NotifierMainV2 {
    public static void main(String[] args) {
        List<NotifierV2> notifierV2s = List.of(new EmailNotifierV2(), new SMSNotifierV2(), new AppPushNotifierV2());

        notifierV2s.forEach(notifierV2 -> notifierV2.notify("welcome"));
    }
}
