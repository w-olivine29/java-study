package ch04network.sub4resourcedisposal.version6shutdownhook;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static ch04network.utils.MyLogger.log;


public class ServerV6 {

    public static final int PORT = 12345;

    public static void main(String[] args) throws IOException {

        // main 스레드는 새로운 연결이 있을 때마다, Session 객체와 별도의 스레드 생성, 별도의 스레드가 Session 객체를 실행하도록 한다
        log("서버 시작");
        SessionManagerV6 sessionManager = new SessionManagerV6();

        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);


        // ShutdownHook 등록 - (일반적인 종료 시 작동 - 예시는 맨 아래 주석, pdf 등 확인)
        ShutdownHook shutdownHook = new ShutdownHook(serverSocket, sessionManager);
        Runtime.getRuntime().addShutdownHook(new Thread(shutdownHook, "shutdown"));


        try {
            while (true) {
                Socket socket = serverSocket.accept(); // 블로킹 (OS blocking queue에 연결정보가 들어오고, 소켓을 생성하기 까지)
                log("소켓 연결: " + socket);

                SessionV6 session = new SessionV6(socket, sessionManager);

                Thread thread = new Thread(session);
                thread.start();
            }
        } catch (IOException e) {
            log("서버 소켓 종료: " + e);
        }


    }

    // ShutdownHook 으로 넣을 작업
    static class ShutdownHook implements Runnable {

        private final ServerSocket serverSocket;
        private final SessionManagerV6 sessionManager;

        public ShutdownHook(ServerSocket serverSocket, SessionManagerV6 sessionManager) {
            this.serverSocket = serverSocket;
            this.sessionManager = sessionManager;
        }

        @Override
        public void run() {

            try {
                sessionManager.closeAll();
                serverSocket.close();

                Thread.sleep(1000); // 자원 정리 대기 (아래 shutdown hook 주석 설명 참고)
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("e = " + e);
            }
        }
    }
}

/* 클라이언트가 아닌 서버에서 연결을 끊는 시나리오

버전 5 까지의 문제

서버의 세션 측)
기존 코드는 exit 나 예외가 발생해야 (보통 클라이언트가 종료됐을 때 등)
finally 나 try-with-resources 로 자원 반납을 했는데,
서버를 종료하는 상황은 세션 측에서 예외로 인식 x
서버에서는 그저, 소켓&세션 만들고 스레드 만들고 실행만 시켜줬었음 (그 외의 역할은 없었음)
그래서 서버 측에서 소켓&세션을 닫을 수 있게 해야하는데,

    생성: 소켓과 세션을 계속 생성
    추적 없음: 생성한 것들을 현재 코드에서 저장하지 않음
    정리 불가능: 참조가 없어서 나중에 접근 불가능
의 이유로 불가능

----
버전 6) 
세션 매니저를 도입
- 모든 세션을 중앙(현재 ServerV6.java) 에서 관리
    - 소켓&세션을 만들고, 참조값을 자료구조에 저장
- 서버 종료 시 세션 매니저를 통해 closeAll() 호출
*/


/* shutdown hook
-----------------------------------------
작동 o  - 셧다운 훅의 실행이 끝날 때까지는 기다려줌 (시간 제한이 있는 경우는 있음)

기본 정상종료)
    모든 NON 데몬 스레드 종료 -> 자바 프로세스 자연 종료


NON 데몬 스레드 종료 여부와 관계없이 자바 프로세스 종료 되는 상황
단 셧다운 훅의 실행이 끝날 때까지는 기다려줌
셧다운 훅의 실행이 끝나면 non 데몬 스레드 실행 여부와 상관 없이 자바 프로세스가 종료됨
-> 다른 스레드가 자원 정리하거나 필요한 로그를 남길 수 있도록 셧다운 훅의 실행을 잠시 대기 할 필요가 있음

    System.exit() 호출 시
    IDE에서 애플리케이션을 정상적으로 중지할 때
    웹 애플리케이션 서버가 정상적으로 종료될 때

시그널에 의한 종료

    SIGTERM (종료 신호) - 일반적인 종료 요청
    SIGINT (인터럽트 신호) - Ctrl+C 입력
    SIGHUP (행업 신호) - 터미널 연결 해제 시

외부 요인에 의한 종료
    운영체제의 셧다운 명령
    사용자가 로그아웃하는 경우
    시스템 재부팅 시


----------------------------------------
작동 x (아예 작동x)

SIGKILL (강제 종료) - kill -9 명령
OutOfMemoryError 등 치명적인 에러로 인한 JVM 크래시
JVM 자체의 내부 오류
전원이 갑자기 차단되는 경우
Runtime.halt() 메서드 호출 시

*/