package ch05chatprogram.client;

import java.io.IOException;

import static ch05chatprogram.utils.MyLogger.log;

public class ClientMain {

    private static final int PORT = 12345;
    public static void main(String[] args) {
        Client client = new Client("localhost", PORT);
        try {
            client.start();
        } catch (IOException e) {
            log(e);
        }
    }
}
