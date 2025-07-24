package was.v1start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static java.nio.charset.StandardCharsets.UTF_8;
import static utils.MyLogger.log;

public class HttpServerV1 {

    private final int port;

    public HttpServerV1(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        log("서버 시작 port: " + port);

        // 현재 버전은 동시요청 불가 (순차적으로 요청 처리 - 거의 동시에 두 곳에서 요청 시 차순위로 밀린 곳은 10초 걸림)
        while (true) {
            Socket socket = serverSocket.accept(); // OS backlog에 있는 웹브라우저 연결 정보로 소켓 생성
            process(socket);
        }
    }

    private void process(Socket socket) throws IOException {

        try (socket;
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), false, UTF_8); // autoFlush: false (한번에 모아서 전송)
        ) {
            String requestString = requestToString(reader);

            // 브라우저가 자동으로 요청하는 favicon은 학습 목적상 무시
            if (requestString.contains("/favicon.ico")) {
                log("favicon 요청");
                return;
            }

            log("HTTP 요청 정보 출력");
            System.out.println(requestString);

            log("HTTP 응답 생성중...");
            responseToClient(writer);
            log("HTTP 응답 전달 완료");

        }
    }

    private static void responseToClient(PrintWriter writer) {
        // 웹 브라우저에 전달하는 내용
        
        //\r (Carriage Return): 커서를 줄의 맨 앞으로 이동 (줄바꿈은 아님)
        // HTTP 공식 스펙에서 다음 라인은 "\r\n"(캐리지 리턴 + 라인피드) 으로 표현 (\n 만 사용해도 대부분의 웹 브라우저는 정상작동)

        String body = "<h1>Hello HTTP</h1>";
        int length = body.getBytes(UTF_8).length;

        StringBuilder sb = new StringBuilder();

        // 시작라인 (<HTTP 버전> <상태 코드> <상태 메시지>)
        sb.append("HTTP/1.1 200 OK\r\n");

        // 헤더 (Content-Type, Set-Cookie, Cache-Control 등의 부가정보)
        sb.append("Content-Type: text/html\r\n"); //HTTP 메세지 바디의 데이터 형태
        sb.append("Content-Length: ").append(length).append("\r\n"); //HTTP 메세지 바디의 데이터 길이

        // header, body 구분 라인
        sb.append("\r\n"); //한 줄 띄우기

        // 바디 (요청에 대한 응답 데이터 (HTML, JSON, 이미지 등))
        sb.append(body);

        log("HTTP 응답 정보 출력");
        sleep(5000); // 서버 처리 시간 (실습 시나리오)
        System.out.println(sb);

        writer.println(sb); // autoFlush: false 설정 ->  println() -> 내부 버퍼에 쌓임  (true일 경우 바로 전송)
        writer.flush(); // 버퍼에 있는 데이터를 실제 전송
    }

    // 클라이언트로 부터 온 요청을 문자열로 변환
    private static String requestToString(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) { // 헤더와 바디 구분 공백라인을 만나고, 헤더까지만 가져옴
                break;
            }
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

// 참고만 하기 (자세한 건 별도의 HTTP 강의에서)

/*
- 시작라인
    - GET: GET 메서드 (조회) - HTTP 메서드
    - / : 요청 경로 (별도의 요청 경로가 없으면 "/" 를 사용)
- 헤더
    - Host: 접속하는 서버 정보
    - User-Agent: 웹 브라우저의 정보
    - Accept: 웹 브라우저가 전달 받을 수 있는 HTTP 응답 메세지 바디 형태
    - Accept-Encoding: 웹 브라우저가 전달 받을 수 있는 인코딩 형태
    - Accept-Language: 웹 브라우저가 전달 받을 수 있는 언어 형태
*/

// 요청 메세지 시작라인, 헤더까지 가져온 것
//GET / HTTP/1.1
//Host: localhost:12345
//Connection: keep-alive
//Cache-Control: max-age=0
//sec-ch-ua: "Not)A;Brand";v="8", "Chromium";v="138", "Google Chrome";v="138"
//sec-ch-ua-mobile: ?0
//sec-ch-ua-platform: "Windows"
//Upgrade-Insecure-Requests: 1
//User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36
//Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7
//Sec-Fetch-Site: none
//Sec-Fetch-Mode: navigate
//Sec-Fetch-User: ?1
//Sec-Fetch-Dest: document
//Accept-Encoding: gzip, deflate, br, zstd
//Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7

/*
GET /.well-known/appspecific/com.chrome.devtools.json HTTP/1.1
Host: localhost:12345
Connection: keep-alive
Sec-Fetch-Site: same-origin
Sec-Fetch-Mode: no-cors
Sec-Fetch-Dest: empty
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36
Accept-Encoding: gzip, deflate, br, zstd
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
*/


