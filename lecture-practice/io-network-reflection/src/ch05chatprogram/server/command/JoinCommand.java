package ch05chatprogram.server.command;

import ch05chatprogram.server.Session;
import ch05chatprogram.server.SessionManager;

import java.io.IOException;

public class JoinCommand implements Command {

    private final SessionManager sessionManager;

    public JoinCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session){
        String username = args[1];
        session.setUsername(username);
        sessionManager.sendAll(username + "님이 입장했습니다.");
    }
}
