package ch05chatprogram.server;

import ch05chatprogram.utils.SocketClose;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static ch05chatprogram.utils.MyLogger.log;


public class Session implements Runnable {

    private final Socket socket;
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;
    private final SessionManager sessionManager;
    private final CommandManager commandManager;

    private boolean isClosed;
    private String username;

    public Session(Socket socket, SessionManager sessionManager, CommandManager commandManager) throws IOException {
        this.socket = socket;
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());
        this.sessionManager = sessionManager;
        this.commandManager = commandManager;

        sessionManager.add(this);
    }

    @Override
    public void run() {
        try {
            while (true) {
                // 클라이언트로부터 문자 수신
                String received = inputStream.readUTF();
                log("client -> server: " + received);

                // 받은 메세지를 클라이언트에서 직접 수행 X (세션은 클라이언트로부터 문자를 받는 역할까지만)
                // 받은 메세지를 전체 클라이언트에게 송신
                commandManager.execute(received, this);
            }

        } catch (IOException e) {
            log(e);
        } finally {
            sessionManager.remove(this);
            sessionManager.sendAll(username + "님이 퇴장했습니다.");
            close();
        }
    }

    public void send(String message) throws IOException {
        log("server -> client: " + message);
        outputStream.writeUTF(message);
    }

    public void close() {
        if (isClosed) {
            return;
        }
        SocketClose.closeAll(socket, inputStream, outputStream);
        isClosed = true;
        log("연결 종료:" + socket);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
