package ch06http.was.httpserver.servlet;

import ch06http.was.httpserver.HttpRequest;
import ch06http.was.httpserver.HttpResponse;
import ch06http.was.httpserver.HttpServlet;

import java.io.IOException;

public class DiscardServlet implements HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {

        // empty
        // 실습에 불필요한 favicon 같은 요청에 처리
    }
}
