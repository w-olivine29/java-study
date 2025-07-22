package ch05chatprogram.server.command;

import ch05chatprogram.server.Session;

import java.io.IOException;

public interface Command {
    
    // 파싱을 한 문자를 받을 것임
    void execute(String[] args, Session session) throws IOException;
}
