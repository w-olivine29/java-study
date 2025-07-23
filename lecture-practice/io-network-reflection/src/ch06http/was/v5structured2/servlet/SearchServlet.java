package ch06http.was.v5structured2.servlet;

import ch06http.was.httpserver.HttpRequest;
import ch06http.was.httpserver.HttpResponse;
import ch06http.was.httpserver.HttpServlet;

import java.io.IOException;

public class SearchServlet implements HttpServlet {

    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        String query = request.getParameter("q");

        response.writeBody("<h1>search</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li>query:" + query + "</li>");
        response.writeBody("<ul>");
    }
}
