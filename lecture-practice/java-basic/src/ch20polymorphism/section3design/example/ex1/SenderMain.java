package ch20polymorphism.section3design.example.ex1;

/* 다중 메세지 발송
 * 한번에 여러 곳에 메시지를 발송
 * 이메일, sms, 페이스북
 * */
public class SenderMain {

    public static void main(String[] args) {
        MessageSender[] senders = {
                new InstagramSender(),
                new EmailSender(),
                new SmsSender(),
        };

        for (MessageSender sender : senders) {
            sender.sendMessage("안녕하세요.");
        }
    }

}
