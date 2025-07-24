package was.httpserver;

import java.io.IOException;

// HTTP + Server + Applet 의 줄임말 (HTTP 서버에서 실행되는 작은 자바 프로그램(애플릿))
// 애플릿: 다른 프로그램 내에서 실행되는 프로그램
public interface HttpServlet {
    
    // 여기에 서비스 개발과 관련된 부분을 구현
    void service(HttpRequest request, HttpResponse response) throws IOException;
}
