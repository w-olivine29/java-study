package was.httpserver.servlet.annotation;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;
import was.httpserver.HttpServlet;
import was.httpserver.PageNotFoundException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 이전버전:
        - 요청을 받을 때마다 O(N) 성능 (해당 경로값을 가진 메서드를 찾기위해 순차적으로 조회)
        - 실수로 인한 중복 매핑에 대한 검증이 없음
   현재버전:
        - 서버를 올릴 떄 해당 서블릿을 생성 - 모든 매핑 메서드를 HashMap에 세팅
          요청을 받으면 서블릿에서 O(1) 성능으로 해당 요청 url의 메서드를 호출
*/
public class AnnotationServletV3 implements HttpServlet {

    private final Map<String, ControllerMethod> pathMap;

    public AnnotationServletV3(List<Object> controllers) {
        pathMap = new HashMap<>();
        initializePathMap(controllers);
    }

    private void initializePathMap(List<Object> controllers) {
        for (Object controller : controllers) {
            for (Method method : controller.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(Mapping.class)) {
                    String path = method.getAnnotation(Mapping.class).value();

                    // 중복 경로 체크 (체크에서 걸리면 서버 못 올림)
                    if (pathMap.containsKey(path)) {
                        ControllerMethod controllerMethod = pathMap.get(path);
                        throw new IllegalArgumentException(String.format(
                                "경로 중복 등록, path=%s, method=%s, 이미 등록된 메서드=%s",
                                path, method, controllerMethod.method));
                    }
                    pathMap.put(path, new ControllerMethod(controller, method));
                }
            }
        }
    }

    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        
        // 해당 요청에 대해 세팅된 map 에서 O(1) 의 성능으로 찾아서 수행
        String path = request.getPath();
        ControllerMethod controllerMethod = pathMap.get(path);
        if (controllerMethod == null) {
            throw new PageNotFoundException("request =" + path);
        }
        controllerMethod.invoke(request, response);
    }


    private static class ControllerMethod {
        private final Object controller;
        private final Method method;

        public ControllerMethod(Object controller, Method method) {
            this.controller = controller;
            this.method = method;
        }

        // 호출할 컨트롤러 메서드의 매개변수를 먼저 확인 후 필요한 값을 동적으로 만들어 전달
        // 스프링 MVC 도 이러한 방식으로 다양한 매개변수의 값을 동적으로 전달
        public void invoke(HttpRequest request, HttpResponse response){
            Class<?>[] parameterTypes = method.getParameterTypes();

            // 길이가 0 -> x
            // 길이가 1 -> response
            // 길이가 2 -> request, response
            Object[] args = new Object[parameterTypes.length];

            for (int i = 0; i < parameterTypes.length; i++) {
                if (parameterTypes[i] == HttpRequest.class) {
                    args[i] = request;
                } else if (parameterTypes[i] == HttpResponse.class) {
                    args[i] = response;
                } else { // 의도한 타입 외 타입이 들어있을 경우
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
}
