package ch05chatprogram.server.command;

import ch05chatprogram.server.Session;
import ch05chatprogram.server.SessionManager;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MessageCommand implements Command {

    private final SessionManager sessionManager;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public MessageCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) {
        String message = args[1];
        sessionManager.sendAll(String.format("%s - [%s] %s",
                LocalDateTime.now().format(formatter),
                session.getUsername(),
                message));
    }
}
