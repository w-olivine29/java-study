package ch05chatprogram.server;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.List;

public class CommandManagerV2 implements CommandManager {

    private final SessionManager sessionManager;
    private static final String DELIMITER = "\\|"; // 정규표현식에서 |는 or연산자이기때문에 리터럴 문자로 인식하게끔 이스케이프 문자 사용
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public CommandManagerV2(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {

        System.out.println(totalMessage);

        if (totalMessage.startsWith("/join")) {
            String[] split = totalMessage.split(DELIMITER);
            String username = split[1];
            session.setUsername(username);
            sessionManager.sendAll(username + "님이 입장했습니다.");

        } else if (totalMessage.startsWith("/message")) {
            String[] split = totalMessage.split(DELIMITER);
            String message = split[1];
            sessionManager.sendAll(String.format("%s - [%s] %s",
                    LocalDateTime.now().format(formatter),
                    session.getUsername(),
                    message));

        } else if (totalMessage.startsWith("/change")) {
            String[] split = totalMessage.split(DELIMITER);
            if (split.length >= 2) {
                String newUsername = split[1];
                sessionManager.sendAll(String.format("%s 님이 %s 으로 닉네임을 변경했습니다.",
                        session.getUsername(), newUsername));

                session.setUsername(newUsername);
            }

        } else if (totalMessage.startsWith("/users")) {
            // 전체 사용자 출력은 요청한 클라이언트 세션쪽에만 송신
            List<String> userNames = sessionManager.getAllUserName();
            StringBuilder sb = new StringBuilder();
            sb.append("전체 접속자: ").append(userNames.size()).append("\n");

            for (String username : userNames) {
                sb.append(" - ").append(username).append("\n");
            }

            session.send(sb.toString());
        } else if (totalMessage.startsWith("/exit")) {
            throw new IOException("exit");
        } else {
            session.send("처리할 수 없는 명령어 입니다. " + totalMessage);
        }
    }
}
