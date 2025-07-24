package was.v6reflection;


import was.httpserver.servlet.DiscardServlet;
import was.v5structured2.servlet.HomeServlet;
import was.httpserver.HttpServer;
import was.httpserver.ServletManager;
import was.httpserver.servlet.reflection.ReflectionServlet;
import was.v6reflection.controller.SearchControllerV6;
import was.v6reflection.controller.SiteControllerV6;

import java.io.IOException;
import java.util.List;

public class ServerMain6 {

    private static final int PORT = 12345;
    public static void main(String[] args) throws IOException {

        List<Object> controllers = List.of(new SiteControllerV6(), new SearchControllerV6());
        ReflectionServlet reflectionServlet = new ReflectionServlet(controllers);

        ServletManager servletManager = new ServletManager();

        // 리플렉션 서블릿을 기본 서블릿으로 등록 (다른 서블릿에서 경로를 찾지 못할 때 해당 서블릿이 항상 호출될 것임)
        servletManager.setDefaultServlet(reflectionServlet);

        // 메서드 이름으로 매핑 불가한 경로는 서블릿 등록
        servletManager.add("/", new HomeServlet()); // "/" 라는 이름은 메서드 이름 매핑 불가
        servletManager.add("/favicon.ico", new DiscardServlet()); // 해당 이름도 메서드 이름 매핑 불가

        // 해당 서버에 맞는 서블릿 세팅한 후 서버를 올림
        HttpServer server = new HttpServer(PORT, servletManager);
        server.start();
    }
}

/*
기존 HTTP 서버의 코드를 전혀 변경하지 않고, 리플렉션 서블릿만 구현하여 새로운 기능 도입
커맨드 패턴으로 만든 서블릿의 단점 해결
  이전버전)
    - 하나의 클래스에 하나의 기능만 넣을 수 있다
    - 새로 만든 클래스를 URL 경로와 계속 매핑해나가야한다.
  현재버전)
    - 한 클래스에 여러 비즈니스 로직 메서드를 넣을 수 있음
    - 리플렉션을 활용하여, 경로와 이름이 동일한 메서드를 동적으로 호출 할 수 있게되었음
     -> 클래스가 추가될 때마다 매핑작업할 필요 없음

next step)
    - 요청 이름과 메서드 이름을 다르게 하고싶다면?
        ex) /site1 요청 -> page1()메서드 호출 하고 싶다면??
    - 메서드 이름으로 처리하기 어려운 URL은 어떻게 하는가?
        - "/", "/favicon.ico"
        - URL은 주로  "-" 구분자 사용 (/add-member)
        
-> 애노테이션 활용
*/
