package was.v1start;

import java.io.IOException;

public class ServerMain1 {

    private static final int PORT = 12345;
    public static void main(String[] args) throws IOException {

        HttpServerV1 server = new HttpServerV1(PORT);
        server.start();
    }
}
