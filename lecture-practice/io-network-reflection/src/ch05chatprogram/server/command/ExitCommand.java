package ch05chatprogram.server.command;

import ch05chatprogram.server.Session;
import ch05chatprogram.server.SessionManager;

import java.io.IOException;
import java.util.List;

public class ExitCommand implements Command {

    @Override
    public void execute(String[] args, Session session) throws IOException {
        throw new IOException("exit");
    }
}
