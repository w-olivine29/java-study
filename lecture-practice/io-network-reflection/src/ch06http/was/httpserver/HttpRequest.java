package ch06http.was.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

public class HttpRequest {

    private String method;
    private String path;
    private final Map<String, String> queryParams = new HashMap<>();
    private final Map<String, String> headers = new HashMap<>();


    public HttpRequest(BufferedReader reader) throws IOException { // 한 줄씩 읽기위해 BufferedReader 사용

        parseRequestLine(reader);
        parseHeaders(reader);

        //TODO: 메시지 바디

    }


    // GET /search?q=안녕 HTTP/1.1  -> 시작라인
    // Host: localhost:12345 -> 헤더
    private void parseRequestLine(BufferedReader reader) throws IOException {

        String requestLine = reader.readLine();
        if (requestLine == null) { //클라이언트가 연결만 하고 데이터 전송 없이 연결 종료시 null 반환 (일부 브라우저의 추가 연결 관련)
            throw new IOException("EOF: No request line received");
        }

        String[] parts = requestLine.split(" "); // [GET, /search?q=안녕, HTTP/1.1]
        if (parts.length != 3) {
            throw new IOException("Invalid request line: " + requestLine);
        }
        this.method = parts[0]; //GET
        String[] pathParts = parts[1].split("\\?"); // [search, q=안녕]
        this.path = pathParts[0];

        if (pathParts.length > 1) {
            parseQueryParameters(pathParts[1]);
        }
    }

    // q=안녕
    // key1=value1&key2=value2
    // q=
    private void parseQueryParameters(String queryString) {
        String[] split = queryString.split("&"); //[key1=value1, key2=value2 ...]
        for (String param : split) {
            String[] keyValue = param.split("=");
            String key = URLDecoder.decode(keyValue[0], UTF_8);
            String value = keyValue.length > 1 ? URLDecoder.decode(keyValue[1], UTF_8) : "";
            this.queryParams.put(key, value);
        }

    }

    //Host: localhost:12345
    //Connection: keep-alive
    //Cache-Control: max-age=0
    private void parseHeaders(BufferedReader reader) throws IOException {
        String line;
        while (!((line = reader.readLine()).isEmpty())) { //공백라인 만나기전까지
            String[] headerParts = line.split(":");
            this.headers.put(headerParts[0].strip(), headerParts[1].strip()); // 앞뒤 공백 제거하고 넣기
        }
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getParameter(String name) {
        return queryParams.get(name);
    }

    public String getHeader(String name) {
        return headers.get(name);
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", queryParams=" + queryParams +
                ", headers=" + headers +
                '}';
    }
}