package ch20polymorphism.section3design.example.ex1;

public class SmsSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("sms 발송: " + message);
    }
}
