package ch04network.sub4resourcedisposal.version5trywithresources;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static utils.MyLogger.log;


public class ClientV5 {
    public static final int PORT = 12345;

    public static void main(String[] args) throws IOException {


        log("클라이언트 시작");
        try (Socket socket = new Socket("localhost", PORT);
             DataInputStream inputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());) {

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
        }


    }
}
