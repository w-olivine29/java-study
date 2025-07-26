package was.v7annotation;


import was.httpserver.HttpServer;
import was.httpserver.HttpServlet;
import was.httpserver.ServletManager;
import was.httpserver.servlet.annotation.AnnotationServletV1;
import was.v7annotation.controller.SearchControllerV7;
import was.v7annotation.controller.SiteControllerV7;

import java.io.IOException;
import java.util.List;

public class ServerMain7 {

    private static final int PORT = 12345;
    public static void main(String[] args) throws IOException {

        List<Object> controllers = List.of(new SiteControllerV7(), new SearchControllerV7());
        HttpServlet annotationServlet = new AnnotationServletV1(controllers);

        ServletManager servletManager = new ServletManager();

        // 애노테이션 서블릿을 기본 서블릿으로 등록
        servletManager.setDefaultServlet(annotationServlet);

        // 해당 서버에 맞는 서블릿 세팅한 후 서버를 올림
        HttpServer server = new HttpServer(PORT, servletManager);
        server.start();
    }
}

/*

*/
