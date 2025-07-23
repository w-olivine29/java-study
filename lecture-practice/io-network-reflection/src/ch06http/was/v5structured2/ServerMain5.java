package ch06http.was.v5structured2;

import ch06http.was.httpserver.HttpServer;
import ch06http.was.httpserver.ServletManager;
import ch06http.was.httpserver.servlet.DiscardServlet;
import ch06http.was.v5structured2.servlet.HomeServlet;
import ch06http.was.v5structured2.servlet.SearchServlet;
import ch06http.was.v5structured2.servlet.Site1Servlet;
import ch06http.was.v5structured2.servlet.Site2Servlet;

import java.io.IOException;

public class ServerMain5 {

    private static final int PORT = 12345;
    public static void main(String[] args) throws IOException {
        ServletManager servletManager = new ServletManager();

        //해당 서비스에 필요한 서블릿을 직접 추가하여 사용
        servletManager.add("/", new HomeServlet());
        servletManager.add("/search", new SearchServlet());
        servletManager.add("/site1", new Site1Servlet());
        servletManager.add("/site2", new Site2Servlet());
        servletManager.add("/favicon.ico", new DiscardServlet()); // 해당 실습은 favicon 요청 무시

        // 해당 서버에 맞는 서블릿 세팅한 후 서버를 올림
        HttpServer server = new HttpServer(PORT, servletManager);
        server.start();
    }
}
