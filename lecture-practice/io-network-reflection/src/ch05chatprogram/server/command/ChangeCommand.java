package ch05chatprogram.server.command;

import ch05chatprogram.server.Session;
import ch05chatprogram.server.SessionManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChangeCommand implements Command {

    private final SessionManager sessionManager;
    public ChangeCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) {
        if (args.length >= 2) {
            String newUsername = args[1];
            sessionManager.sendAll(String.format("%s 님이 %s 으로 닉네임을 변경했습니다.",
                    session.getUsername(), newUsername));

            session.setUsername(newUsername);
        }
    }
}
