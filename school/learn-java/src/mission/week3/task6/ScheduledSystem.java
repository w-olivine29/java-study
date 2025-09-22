package mission.week3.task6;

import mission.week3.task5.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// 41기 유도경
public class ScheduledSystem {
    public static void main(String[] args) {
        ScheduledSystem scheduledSystem = new ScheduledSystem(
                Executors.newScheduledThreadPool(3),
                new EmailService()
        );

        System.out.printf("[%S (%S)] 이메일 발송 시작\n", LocalDateTime.now(), Thread.currentThread().getName());
        scheduledSystem.sendEmail();

    }

    private final ScheduledExecutorService scheduledEs;
    private final EmailService emailService;


    public ScheduledSystem(ScheduledExecutorService scheduledEs, EmailService emailService) {
        this.scheduledEs = scheduledEs;
        this.emailService = emailService;
    }

    private void sendEmail() {

        // 수신자 목록을 가져왔다고 가정
        List<User> users = List.of(
                new User("사용자 A"),
                new User("사용자 B"),
                new User("사용자 C"),
                new User("사용자 D"),
                new User("사용자 E"),
                new User("사용자 F")
        );


        scheduledEs.scheduleAtFixedRate(

                // 필드사용을 위해 람다가 아닌 익명클래스로 구현
                new Runnable() {
                    final AtomicInteger currentIndex = new AtomicInteger(0);

                    @Override
                    public void run() {

                        if (currentIndex.get() >= users.size()) {
                            scheduledEs.shutdown();
                            return;
                        }

                        emailService.sendEmail(
                                users.get(currentIndex.get()).getName(),
                                "고객님 안녕하십니까.",
                                "인사드립니다.");

                        currentIndex.incrementAndGet();
                    }
                }, 5000, 10000, TimeUnit.MILLISECONDS
        );
    }
}
