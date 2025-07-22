package ch05chatprogram.server.commandmanager;

import ch05chatprogram.server.Session;
import ch05chatprogram.server.SessionManager;
import ch05chatprogram.server.command.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandManagerV3 implements CommandManager {

    private final SessionManager sessionManager;
    private static final String DELIMITER = "\\|"; //split() 에서는 정규식 사용 - 정규표현식에서 |는 or연산자이기때문에 리터럴 문자로 인식하게끔 이스케이프 문자 사용

    // 커맨드 패턴 도입
    // 동시성 자료구조를 사용하지 않는 이유) 여러 스레드가 해당 map을 호출하지만, 초기화 후 데이터를 전혀 변경하지 않기때문에 동시 조회해도 무관
    private final Map<String, Command> commands = new HashMap<>();


    public CommandManagerV3(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        commands.put("/join", new JoinCommand(sessionManager));
        commands.put("/change", new ChangeCommand(sessionManager));
        commands.put("/message", new MessageCommand(sessionManager));
        commands.put("/users", new UsersCommand(sessionManager));
        commands.put("/exit", new ExitCommand());
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {
        String[] args = totalMessage.split(DELIMITER);
        Command command = commands.get(args[0]);
        if (command == null) {
            session.send("처리할 수 없는 명령어 입니다: " + totalMessage);
            return;
        }

        command.execute(args, session);
    }
}
