package was.httpserver.servlet.annotation;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;
import was.httpserver.HttpServlet;
import was.httpserver.PageNotFoundException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class AnnotationServletV2 implements HttpServlet {

    private final List<Object> controllers;

    public AnnotationServletV2(List<Object> controllers) {
        this.controllers = controllers;
    }

    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {

        String path = request.getPath();

        for (Object controller : controllers) {
            for (Method method : controller.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(Mapping.class)
                        && method.getAnnotation(Mapping.class).value().equals(path)) {

                    invoke(controller, method, request, response);
                    return;
                }
            }
        }
        throw new PageNotFoundException("request =" + path);

    }

    // 호출할 컨트롤러 메서드의 매개변수를 먼저 확인 후 필요한 값을 동적으로 만들어 전달
    // 스프링 MVC 도 이러한 방식으로 다양한 매개변수의 값을 동적으로 전달
    private void invoke(Object controller, Method method, HttpRequest request, HttpResponse response) {

        Class<?>[] parameterTypes = method.getParameterTypes();

        // 길이가 0 -> x
        // 길이가 1 -> response
        // 길이가 2 -> request, response
        Object[] args = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i] == HttpRequest.class) {
                args[i] = request;
            }else if(parameterTypes[i] == HttpResponse.class){
                args[i] = response;
            }else { // 의도한 타입 외 타입이 들어있을 경우
                throw new IllegalArgumentException("Unsupported parameter type: " + parameterTypes[i]);
            }
        }

        try {
            //invoke(Object obj, Object... args)
            // Object... args  -> 가변인자(내부적으로 배열로 처리됨)
            method.invoke(controller, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
