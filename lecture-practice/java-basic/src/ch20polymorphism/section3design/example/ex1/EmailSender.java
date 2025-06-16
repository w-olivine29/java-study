package ch20polymorphism.section3design.example.ex1;

public class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("email 발송: " + message);
    }
}
