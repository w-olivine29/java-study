package ch20polymorphism.section3design.example.ex1;

public class InstagramSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("instagram 메세지 발송: " + message);
    }
}
