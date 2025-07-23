package ch06http.was.httpserver.servlet;

import ch06http.was.httpserver.HttpRequest;
import ch06http.was.httpserver.HttpResponse;
import ch06http.was.httpserver.HttpServlet;

import java.io.IOException;

public class InternalErrorServlet implements HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        response.setStatusCode(500);
        response.writeBody("<h1>Internal Error</h1>");
    }
}
