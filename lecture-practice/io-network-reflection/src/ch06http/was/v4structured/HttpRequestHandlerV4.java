package ch06http.was.v4structured;

import ch06http.was.httpserver.HttpRequest;
import ch06http.was.httpserver.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.nio.charset.StandardCharsets.UTF_8;
import static utils.MyLogger.log;

// 클라이언트가 전달한 HTTP 요청 처리
// 동시에 요청한 수 만큼 별도의 스레드에서 수행
public class HttpRequestHandlerV4 implements Runnable {

    private final Socket socket;

    public HttpRequestHandlerV4(Socket socket) {
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

            HttpRequest request = new HttpRequest(reader);
            HttpResponse response = new HttpResponse(writer);

            // 브라우저가 자동으로 요청하는 favicon은 학습 목적상 무시
            if (request.getPath().equals("/favicon.ico")) {
                log("favicon 요청");
                return;
            }

            log("HTTP 요청 정보 출력");
            System.out.println(request);

            if (request.getPath().equals("/site1")) {
                site1(response);
            } else if (request.getPath().equals("/site2")) {
                site2(response);
            } else if (request.getPath().equals("/search")) {
                search(request, response);
            } else if (request.getPath().equals("/")) {
                home(response);
            } else {
                notFound(response);
            }

            log("HTTP 응답 전달 완료");

        }
    }

    private void home(HttpResponse response) {

        response.writeBody("<h1>Home</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li><a href='/site1'>site1</a></li>");
        response.writeBody("<li><a href='/site2'>site2</a></li>");
        response.writeBody("<li><a href='/search?q=hello'>검색</a></li>");
        response.writeBody("<ul>");
        response.flush();

    }

    private void site1(HttpResponse response) {
        response.writeBody("<h1>site1</h1>");
        response.flush();

    }

    private void site2(HttpResponse response) {
        response.writeBody("<h1>site2</h1>");
        response.flush();

    }

    private void notFound(HttpResponse response) {
        response.setStatusCode(404);
        response.writeBody("<h1>404 페이지를 찾을 수 없습니다</h1>");
        response.flush();
    }


    private void search(HttpRequest request, HttpResponse response) {
        String query = request.getParameter("q");

        response.writeBody("<h1>search</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li>query:" + query + "</li>");
        response.writeBody("<ul>");
        response.flush();
    }
}

/*
HttpRequest, HttpResponse 객체를 구현하여, 요청과 응답을 구조화

- HTTP 서버와 관련된 클래스 (서버를 작동시키기 위한 부분)
    - HttpServer, HttpRequestHandler, HttpRequest, HttpResponse
- 서비스 개발을 위한 로직
    - home(), site(), site2(), search(), notFound()

웹을 통한 새로운 서비스를 만들 때, 기존 코드에서 HTTP 서버와 관련된 부분은 거의 재사용,
서비스 개발을 위한 로직만 추가하면 된다.
*/