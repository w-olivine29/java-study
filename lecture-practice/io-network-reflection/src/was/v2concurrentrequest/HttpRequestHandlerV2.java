package was.v2concurrentrequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.nio.charset.StandardCharsets.UTF_8;
import static utils.MyLogger.log;

// 클라이언트가 전달한 HTTP 요청 처리
// 동시에 요청한 수 만큼 별도의 스레드에서 수행
public class HttpRequestHandlerV2 implements Runnable {

    private final Socket socket;

    public HttpRequestHandlerV2(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            process(socket);
        } catch (Exception e) {
            log(e);
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

