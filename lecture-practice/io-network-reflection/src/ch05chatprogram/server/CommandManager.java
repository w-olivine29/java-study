package ch05chatprogram.server;

import java.io.IOException;

// 클라이언트에게 전달받은 메세지를 처리하는 인터페이스
// 향후 구현체를 점진적으로 변경하기 위해 인터페이스로 사용
public interface CommandManager {

    void execute(String totalMessage, Session session) throws IOException;
}
