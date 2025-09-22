package mission.week3.task6;

import java.time.LocalDateTime;

// 41기 유도경
public class EmailService {

    public void sendEmail(String destination, String title, String content) {
        Email email = new Email("here", destination);
        email.setTitle(title);
        email.setContent(content);

        // 메일 보내는 로직이 있다고 가정

        printSendMailResult(email);
    }

    private void printSendMailResult(Email email) {
        System.out.printf("[%s (%s)] 이메일 발송 to: %s\n",
                LocalDateTime.now(),
                Thread.currentThread().getName(),
                email.getTitle()
        );
    }
}
