package was.v3addfunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;
import static utils.MyLogger.log;

// 클라이언트가 전달한 HTTP 요청 처리
// 동시에 요청한 수 만큼 별도의 스레드에서 수행
public class HttpRequestHandlerV3 implements Runnable {

    private final Socket socket;

    public HttpRequestHandlerV3(Socket socket) {
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

            // 시작 라인으로 요청을 구분?
            if (requestString.startsWith("GET /site1")) {
                site1(writer);
            } else if (requestString.startsWith("GET /site2")) {
                site2(writer);
            } else if (requestString.startsWith("GET /search")) {
                search(writer, requestString);
            } else if (requestString.startsWith("GET / ")) { // 슬래시 뒤에 공백이 와야 home 으로 정확히 매칭
                home(writer);
            } else {
                notFound(writer);
            }

            //responseToClient(writer);
            log("HTTP 응답 전달 완료");

        }
    }

    private void home(PrintWriter writer) {

        // 원칙적으로 Content-Length 계산해서 전달해야하나, 예제를 단순화 (생략해도 대부분은 정상작동)
        writer.println("HTTP/1.1 200 OK"); // 시작라인
        writer.println("Content-Type: text/html; charset=UTF-8"); //헤더
        writer.println(); // 헤더 - 바디 경계 공백라인
        writer.println("<h1>Home</h1>");
        writer.println("<ul>");
        writer.println("<li><a href='/site1'>site1</a></li>");
        writer.println("<li><a href='/site2'>site2</a></li>");
        writer.println("<li><a href='/search?q=hello'>검색</a></li>");
        writer.println("<ul>");
        writer.flush();
    }

    private void site1(PrintWriter writer) {

        // 원칙적으로 Content-Length 계산해서 전달해야하나, 예제를 단순화 (생략해도 대부분은 정상작동)
        writer.println("HTTP/1.1 200 OK"); // 시작라인
        writer.println("Content-Type: text/html; charset=UTF-8"); //헤더
        writer.println(); // 헤더 - 바디 경계 공백라인
        writer.println("<h1>site1</h1>");
        writer.flush();
    }

    private void site2(PrintWriter writer) {

        // 원칙적으로 Content-Length 계산해서 전달해야하나, 예제를 단순화 (생략해도 대부분은 정상작동)
        writer.println("HTTP/1.1 200 OK"); // 시작라인
        writer.println("Content-Type: text/html; charset=UTF-8"); //헤더
        writer.println(); // 헤더 - 바디 경계 공백라인
        writer.println("<h1>site2</h1>");
        writer.flush();
    }

    private void notFound(PrintWriter writer) {
        // 원칙적으로 Content-Length 계산해서 전달해야하나, 예제를 단순화 (생략해도 대부분은 정상작동)
        writer.println("HTTP/1.1 404 Not Found"); // 시작라인
        writer.println("Content-Type: text/html; charset=UTF-8"); //헤더
        writer.println(); // 헤더 - 바디 경계 공백라인
        writer.println("<h1>404 페이지를 찾을 수 없습니다</h1>");
        writer.flush();
    }


    private void search(PrintWriter writer, String requestString) {

        //GET /search?q=hello HTTP/1.1
        // 쿼리 스트링 파싱
        int startIdx = requestString.indexOf("q=");
        int endIndex = requestString.indexOf(" ", startIdx + 2);
        String query = requestString.substring(startIdx + 2, endIndex);//hello
        String decode = URLDecoder.decode(query, UTF_8); //URL 에서 퍼센트인코딩된 값이 넘어오기때문에 디코딩해줘야함

        // 원칙적으로 Content-Length 계산해서 전달해야하나, 예제를 단순화 (생략해도 대부분은 정상작동)
        writer.println("HTTP/1.1 200 OK"); // 시작라인
        writer.println("Content-Type: text/html; charset=UTF-8"); //헤더
        writer.println(); // 헤더 - 바디 경계 공백라인
        writer.println("<h1>search</h1>");
        writer.println("<ul>");
        writer.println("<li>query:" + query + "</li>");
        writer.println("<li>decode:" + decode + "</li>");
        writer.println("<ul>");
        writer.flush();
    }

/*    private static void responseToClient(PrintWriter writer) {
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
        //sleep(5000); // 서버 처리 시간 (실습 시나리오)
        System.out.println(sb);

        writer.println(sb); // autoFlush: false 설정 ->  println() -> 내부 버퍼에 쌓임  (true일 경우 바로 전송)
        writer.flush(); // 버퍼에 있는 데이터를 실제 전송
    }*/

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


/*
- 시작라인과 헤더
    시작라인(메소드, URL, HTTP 버전)과 헤더의 이름은 반드시 ASCII 문자만 사용
    다른 인코딩(UTF-8, EUC-KR 등) 사용 불가
    HTTP 프로토콜의 기본 규격으로 정해진 제약사항

- 메시지 바디
    메시지 바디 부분은 다양한 인코딩 사용 가능
    Content-Type 헤더를 통해 인코딩 방식 명시
    예: Content-Type: text/html; charset=UTF-8


브라우저 창에서 입력:
http://localhost:12345/search?q=안녕

실제 HTTP 요청으로 전송:
http://localhost:12345/search?q=%EC%95%88%EB%85%95


이때 "퍼센트 인코딩" 사용

퍼센트 인코딩 (Percent Encoding)
URL에 ASCII가 아닌 문자(한글 등)를 포함할 때 사용하는 인코딩 방식

인코딩 과정:

    한글을 UTF-8로 인코딩
    각 바이트를 16진수로 변환
    각 바이트 앞에 % 기호 추가

    이런 방식으로 ASCII 문자만으로 표현하게 하는 것이다.

퍼센트 인코딩 예시)
    문자: 안
    UTF-8 인코딩: 0xEC 0x95 0x88 (3바이트)
    퍼센트 인코딩: %EC%95%88

    문자: 녕
    UTF-8 인코딩: 0xEB 0x85 0x95 (3바이트)
    퍼센트 인코딩: %EB%85%95
*/