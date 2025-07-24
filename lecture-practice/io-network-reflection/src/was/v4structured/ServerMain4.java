package was.v4structured;

import java.io.IOException;

public class ServerMain4 {

    private static final int PORT = 12345;
    public static void main(String[] args) throws IOException {

        HttpServerV4 server = new HttpServerV4(PORT);
        server.start();
    }
}
