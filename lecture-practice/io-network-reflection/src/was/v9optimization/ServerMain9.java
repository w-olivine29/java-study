package was.v9optimization;


import was.httpserver.HttpServer;
import was.httpserver.HttpServlet;
import was.httpserver.ServletManager;
import was.httpserver.servlet.annotation.AnnotationServletV3;
import was.v9optimization.controller.SearchControllerV9;
import was.v9optimization.controller.SiteControllerV9;

import java.io.IOException;
import java.util.List;

public class ServerMain9 {

    private static final int PORT = 12345;
    public static void main(String[] args) throws IOException {

        List<Object> controllers = List.of(new SiteControllerV9(), new SearchControllerV9());
        HttpServlet annotationServlet = new AnnotationServletV3(controllers); // 동적바인딩 서블릿

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
