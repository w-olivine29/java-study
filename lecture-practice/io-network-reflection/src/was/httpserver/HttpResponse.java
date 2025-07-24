package was.httpserver;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class HttpResponse {

    private final PrintWriter writer;
    private int statusCode = 200;
    private final StringBuilder bodyBuilder = new StringBuilder();
    private String contentType = "text/html; charset=UTF-8"; // 가운데 세미콜론을 누락했더니 정상동작x

    public HttpResponse(PrintWriter writer) {
        this.writer = writer;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void writeBody(String body) {
        bodyBuilder.append(body);
    }

    // 상태코드, 바디 내용 등 세팅 완료한 뒤 전송할 때 호출
    public void flush() {
        int contentLength = bodyBuilder.toString()
                .getBytes(StandardCharsets.UTF_8).length;
        writer.println("HTTP/1.1 200 " + statusCode + " " + getReasonPhrase(statusCode));
        writer.println("Content-Type: " + contentType);
        writer.println("Content-Length " + contentLength);
        writer.println();
        writer.println(bodyBuilder);
        writer.flush();
    }

    private String getReasonPhrase(int statusCode) {
        return switch (statusCode) {
            case 200 -> "OK";
            case 404 -> "Not Found";
            case 500 -> "Internal Server Error";
            default -> "Unknown status";
        };
    }
}
