package webservice;

import was.httpserver.HttpServer;
import was.httpserver.HttpServlet;
import was.httpserver.ServletManager;
import was.httpserver.servlet.DiscardServlet;
import was.httpserver.servlet.annotation.AnnotationServletV3;

import java.io.IOException;
import java.util.List;

public class MemberServiceMain {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {

        MemberRepository memberRepository = new FileMemberRepository();

        HttpServlet servlet = new AnnotationServletV3(List.of(new MemberController(memberRepository)));
        ServletManager servletManager = new ServletManager();
        servletManager.setDefaultServlet(servlet);
        servletManager.add("/favicon.ico", new DiscardServlet());

        HttpServer httpServer = new HttpServer(PORT, servletManager);
        httpServer.start();
    }
}
/* 구성, 사용 역할
해당 클래스는 어떤 코드 블록을 만드는 것이 아닌,
지금껏 구현한 클래스들을 조립하는 듯하다.
어떤 구현체를 사용할지 선택
필요한 컴포넌트를 구성하는 것과 같다.

MemberServiceMain 은 "프로젝트를 구성"하는 역할 담당
나머지 클래스들은 실제 기능을 제공하는 "사용 역할" 담당

구성역할 & 사용역할 분리 시 장점
   - 유연성 향상
        - 프로젝트의 구성을 쉽게 변경 가능 (구현체 교체)
   - 테스트 용이성 
        - 각 컴포넌트를 독립적으로 테스트 가능 (구성 로직과 실제 기능 로직이 분리 돼있어 단위테스트 용이)
   - 코드 재사용성 증가
        - 각 컴포넌트는 독립적이므로 다른 프로젝트에서도 재사용 가능 
   - 관심사의 분리
        - 구성 로직과 비즈니스 로직이 분리돼있어 각 부분에 집중 가능
   - 유지보수 용이성
        - 전체 시스템의 구조 이해 용이
        - 특정 부분을 수정할 때 다른 부분에 미치는 영향 최소화
   - 확장성 개선
        - 새로운 기능이나 컴포넡트 추가 시, 기존 코드를 크게 수정하지 않고도 
            MemberServiceMain 에 새로운 구성 추가 가능
*/