package ch04network.sub4resourcedisposal.version6shutdownhook;

import java.util.ArrayList;
import java.util.List;

// 동시성 처리 필요
public class SessionManagerV6 {

    private List<SessionV6> sessions = new ArrayList<>();

    public synchronized void add(SessionV6 session) {
        sessions.add(session);
    }

    public synchronized void remove(SessionV6 sessionV6) {
        sessions.remove(sessionV6);
    }

    public synchronized void closeAll() {
        for (SessionV6 session : sessions) {
            session.close();
        }
        sessions.clear();
    }
}
