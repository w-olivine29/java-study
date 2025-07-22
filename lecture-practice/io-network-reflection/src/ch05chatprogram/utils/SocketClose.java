package ch05chatprogram.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import static ch04network.utils.MyLogger.log;

public class SocketClose {

    public static void closeAll(Socket socket, InputStream input, OutputStream output) {

        // 자원 생성 순서 역순으로 닫아주기
        close(input);
        close(output);
        close(socket);
    }

    public static void close(OutputStream output) {
        if (output != null) {
            try {
                output.close();
            } catch (IOException e) {
                log(e.getMessage());
            }
        }
    }

    public static void close(InputStream input) {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                log(e.getMessage());
            }
        }
    }

    public static void close(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                log(e.getMessage());
            }
        }
    }
}

/*
자원정리 과정에서 문제가 발생해도 코드에서 직접 대응할 수 있는 부분은 거의 없음
이 경우 로그를 남겨서 인지할 수 있게 하는 정도면 충분

각각의 예외를 잡아서 처리했기에, 하나를 닫는 과정에서 예외가 발생해도, 다음 자원을 닫을 수 있음
 
*/