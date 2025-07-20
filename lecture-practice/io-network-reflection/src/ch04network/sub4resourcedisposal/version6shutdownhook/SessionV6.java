package ch04network.sub4resourcedisposal.version6shutdownhook;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static ch04network.utils.MyLogger.log;
import static ch04network.utils.SocketClose.*;

// 버전을 클라이언트, 서버 버전에 맞춰놓음
public class SessionV6 implements Runnable {
    private final Socket socket; // 서버 쪽에서 accept() 완료 후 받은 소켓객체
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;
    private final SessionManagerV6 sessionManager;
    private boolean closed;


    public SessionV6(Socket socket, SessionManagerV6 sessionManager) throws IOException {
        this.socket = socket;
        this.inputStream = new DataInputStream(socket.getInputStream());
        this.outputStream = new DataOutputStream(socket.getOutputStream());

        this.sessionManager = sessionManager;
        sessionManager.add(this);
    }

    @Override
    public void run() {

        try {
            while (true) {

                // 블로킹 메서드
                // 클라이언트에서 연결을 끊거나 해당 세션을 반납한 상황이면 여기서 예외발생 -> 해당 스레드도 실행완료 
                String received = inputStream.readUTF(); 
                log("client -> server: " + received);

                //
                if (received.equals("exit")) {
                    break;
                }

                // 메세지 송신
                String toSend = received + "World!";
                outputStream.writeUTF(toSend);
                log("client <- server: " + toSend);
            }

        } catch (IOException e) {
            log(e);
        } finally {
            sessionManager.remove(this);
            close();
        }

    }


    // 클라이언트 연결 끊겼을 때 (exit, 예외) & 서버 종료 시 동시에 호출될 수 있기 때문에 동기화 처리
    public synchronized void close() {

        // 동기 호출은 막았지만, 두번 호출 될 수 있기때문에 flag 조건문 추가
        if(closed){
            return;
        }

        closeAll(socket, inputStream, outputStream);
        closed = true;
        log(String.format("연결 종료: %s", socket));
    }
}

/*
try-with-resources를 사용하지 않는 이유와 외부 close() 메서드를 제공하는 이유:

1. 자원 정리의 이원화 문제
   - 기존: try-with-resources로 자동 정리 (exit 또는 예외 발생 시 - 클라이언트 측에서 연결 종료한 상황)
   - 현재: 예외 발생 시 (기존 상황) + 서버 종료 시 모두 처리 필요
            서버 종료 시엔 기존의 try-with-resources 로 자원 반납 불가

2. 서버 종료 시나리오
   - 서버 애플리케이션이 종료될 때 모든 활성 세션을 강제 종료해야 함
   - try-with-resources는 해당 try 블록이 끝날 때만 작동
   - 외부에서 세션을 종료하려면 public close() 메서드 필요

3. 세션 매니저 패턴
   - SessionManager가 모든 세션을 관리
   - 서버 종료 시 sessionManager.closeAll() 호출
   - 각 세션의 close() 메서드를 외부에서 호출 가능해야 함

4. 일관성 있는 자원 정리
   - 예외 발생 시, exit : finally 블록에서 close() 호출
   - 서버 종료 시: 세션 매니저에서 close() 호출
   - 두 경우 모두 동일한 close() 메서드 사용으로 일관성 유지

5. 핵심 예외 보존
   - finally 블록의 close()에서 예외 발생 시 핵심 예외가 사라지는 문제
   - close() -> closeAll() 메서드 내부에서 개별적으로 예외를 잡아 처리하므로 해결
*/