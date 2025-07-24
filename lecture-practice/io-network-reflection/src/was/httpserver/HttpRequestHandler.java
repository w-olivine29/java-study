package was.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.nio.charset.StandardCharsets.UTF_8;
import static utils.MyLogger.log;

public class HttpRequestHandler implements Runnable {

    private final Socket socket;
    private final ServletManager servletManager;

    public HttpRequestHandler(Socket socket, ServletManager servletManager) {
        this.socket = socket;
        this.servletManager = servletManager;
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

            log("HTTP 요청: " + request);
            servletManager.execute(request, response);
            response.flush();
            log("HTTP 응답 전달 완료");
        }
    }
}

/* HTTP 서버와 서비스 개발을 위한 로직이 명확하게 분리

- HTTP 서버와 관련된 부분 - was.httpserver 패키지
    - HttpServer, HttpRequestHandler
    - HttpRequest, HttpResponse
    - was.http.servlet 패키지
        - InternalErrorServlet, NotFoundServlet, DiscardServlet

- 서비스 개발을 위한 로직 - v5.servlet 패키지
    - HomeServlet
    - SearchServlet
    - Site1Servlet
    - Site2Servlet

다른 HTTP 기반 프로젝트 시작 시, 
- HTTP 서버와 관련된 패키지의 코드를 그대로 재사용 가능
- 해당 서비스에 필요한 서블릿 구현 후 서블릿 매니저에 등록 후 서버 실행

pdf 웹 애플리케이션 서버의 역사 참고
*/