package was.v8dynamicbinding.controller;

import was.httpserver.HttpResponse;
import was.httpserver.servlet.annotation.Mapping;

// 이전버전: request가 필요하지 않음에도 request를 받아왔음
// 현재버전: 서블릿에서 필요한 인수만 넘길 수 있게 변경
public class SiteControllerV8 {
    
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

    @Mapping("/favicon.ico")
    public void favicon() {
    }
}
