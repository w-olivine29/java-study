package ch04network.sub4resourcedisposal.version4finally;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static ch04network.utils.MyLogger.log;
import static ch04network.utils.SocketClose.*;



public class ClientV4 {
    public static final int PORT = 12345;

    public static void main(String[] args) throws IOException {

        Socket socket = null;
        DataInputStream inputStream = null;
        DataOutputStream outputStream = null;

        log("클라이언트 시작");
        try {
            socket = new Socket("localhost", PORT); // Connection refused: connect 해당 포트에 서버가 올라가지 있지 않다면 예외발생

            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            log("소켓 연결:" + socket);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("전송 문자: ");
                String toSend = scanner.nextLine();

                // 서버에게 문자 보내기
                outputStream.writeUTF(toSend);
                log("client -> server: " + toSend);

                if (toSend.equals("exit")) {
                    break;
                }

                // 서버로부터 문자 받기
                String received = inputStream.readUTF();
                log("client <- server: " + received);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            closeAll(socket, inputStream, outputStream);
            log("연결 종료:" + socket);
        }


    }
}
