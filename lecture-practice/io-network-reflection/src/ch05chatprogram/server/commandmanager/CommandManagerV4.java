package ch05chatprogram.server.commandmanager;

import ch05chatprogram.server.Session;
import ch05chatprogram.server.SessionManager;
import ch05chatprogram.server.command.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandManagerV4 implements CommandManager {

    private final SessionManager sessionManager;
    private static final String DELIMITER = "\\|"; //split() 에서는 정규식 사용 - 정규표현식에서 |는 or연산자이기때문에 리터럴 문자로 인식하게끔 이스케이프 문자 사용

    // 커맨드 패턴 도입
    // 동시성 자료구조를 사용하지 않는 이유) 여러 스레드가 해당 map을 호출하지만, 초기화 후 데이터를 전혀 변경하지 않기때문에 동시 조회해도 무관
    private final Map<String, Command> commands = new HashMap<>();
    private final DefaultCommand defaultCommand = new DefaultCommand();


    public CommandManagerV4(SessionManager sessionManager) {
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

        // Null Object 패턴 (null을 객체처럼 처리하는 방법)
        Command command = commands.getOrDefault(args[0], defaultCommand);
        command.execute(args, session);
    }
}
/* Command Pattern

특징)
    - 분리: 작업을 호출하는 객체와 작업을 수행하는 객체 분리
    - 확장성: 기존 코드를 변경하지 않고 새로운 명령을 추가할 수 있음

장점)
    - 새로운 커맨드 추가 용이
        새로운 커맨드 구현체만 만들고, 기존 코드는 변경 최소화
    - 작업을 호출하는 객체와 작업을 수행하는 객체 분리
    - 각각의 기능이 명확하게 분리
        어떤 기능을 수정해야할 때, 수정해야하는 클래스의 인식이 아주 명확해짐
        
단점) 
    - 복잡성 증가
        간단한 작업을 수행하는 경우에도 여러 클래스를 생성해야함
            -> 단순히 if문 몇개로 해결할 수 있는 상황에서는 도입하는게 좋은 설계가 아닐 수 있음

-> 기능이 어느정도 있고, 각각의 기능이 명확하게 나뉘어질 수 있고, 향후 기능 확장까지 고려한다면 커맨드 패턴 고려
*/