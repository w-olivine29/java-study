package ch06http.was.v5structured2.servlet;

import ch06http.was.httpserver.HttpRequest;
import ch06http.was.httpserver.HttpResponse;
import ch06http.was.httpserver.HttpServlet;

import java.io.IOException;

public class Site2Servlet implements HttpServlet {

    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        response.writeBody("<h1>site2</h1>");
    }
}
