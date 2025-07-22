package ch05chatprogram.server;

import ch05chatprogram.server.commandmanager.CommandManager;
import ch05chatprogram.server.commandmanager.CommandManagerV2;
import ch05chatprogram.server.commandmanager.CommandManagerV3;
import ch05chatprogram.server.commandmanager.CommandManagerV4;

import java.io.IOException;

import static ch05chatprogram.utils.MyLogger.log;

public class ServerMain {
    private static final int PORT = 12345;

    public static void main(String[] args) {

        SessionManager sessionManager = new SessionManager();

        // 점진적으로 버전업 예정
        CommandManager commandManager = new CommandManagerV4(sessionManager);

        Server server = new Server(PORT, sessionManager, commandManager);

        try {
            server.start();
        } catch (IOException e) {
            log("서버 시작 실패");
        }
    }
}
