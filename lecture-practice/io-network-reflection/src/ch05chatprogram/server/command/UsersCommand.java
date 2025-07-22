package ch05chatprogram.server.command;

import ch05chatprogram.server.Session;
import ch05chatprogram.server.SessionManager;

import java.io.IOException;
import java.util.List;

public class UsersCommand implements Command {

    private final SessionManager sessionManager;
    public UsersCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        // 전체 사용자 출력은 요청한 클라이언트 세션쪽에만 송신
        List<String> userNames = sessionManager.getAllUserName();
        StringBuilder sb = new StringBuilder();
        sb.append("전체 접속자: ").append(userNames.size()).append("\n");

        for (String username : userNames) {
            sb.append(" - ").append(username).append("\n");
        }

        session.send(sb.toString());
        }
    }

