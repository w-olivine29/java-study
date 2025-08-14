package ch09defaultmethod.ex.step1;

public class AppPushNotifier implements Notifier {
    @Override
    public void notify(String message) {
        System.out.println("[App] " + message);
    }
}
