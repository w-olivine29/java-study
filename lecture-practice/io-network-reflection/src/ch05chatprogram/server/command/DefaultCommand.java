package ch05chatprogram.server.command;

import ch05chatprogram.server.Session;
import ch05chatprogram.server.SessionManager;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DefaultCommand implements Command {


    @Override
    public void execute(String[] args, Session session) throws IOException {
        session.send("처리할 수 없는 명령어 입니다: " + Arrays.toString(args));
    }
}
