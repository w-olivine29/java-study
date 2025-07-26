package was.v9optimization.controller;

import was.httpserver.HttpResponse;
import was.httpserver.servlet.annotation.Mapping;


public class SiteControllerV9 {
    
    @Mapping("/")
    public void home(HttpResponse response) {
        response.writeBody("<h1>home</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li><a href='/site1'>site1</a></li>");
        response.writeBody("<li><a href='/site2'>site2</a></li>");
        response.writeBody("<li><a href='/search?q=hello'>검색</a></li>");
        response.writeBody("<ul>");
    }

    @Mapping("/site1")
    public void site1(HttpResponse response) {
        response.writeBody("<h1>site1</h1>");
    }

    @Mapping("/site2")
    public void site2(HttpResponse response) {
        response.writeBody("<h1>site2</h1>");
    }

    // 중복 매핑 실습용
/*    @Mapping("/site2")
    public void site3(HttpResponse response) {
        response.writeBody("<h1>site2</h1>");
    }*/

    @Mapping("/favicon.ico")
    public void favicon() {
    }
}
