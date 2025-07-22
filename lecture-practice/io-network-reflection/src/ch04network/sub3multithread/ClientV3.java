package ch04network.sub3multithread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static utils.MyLogger.log;


//코드분석 추가설명은 pdf 참고 (필수)
public class ClientV3 {
    public static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");

        Socket socket = new Socket("localhost", PORT); // Connection refused: connect 해당 포트에 서버가 올라가지 있지 않다면 예외발생

        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        log("소켓 연결:" + socket);

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("전송 문자: ");
            String toSend = scanner.nextLine();

            // 서버에게 문자 보내기
            outputStream.writeUTF(toSend);
            log("client -> server: " + toSend);

            if(toSend.equals("exit")){
                break;
            }

            // 서버로부터 문자 받기
            String received = inputStream.readUTF();
            log("client <- server: " + received);
        }


        // 자원 정리 (현 예제에서는 간략하게)
        log("연결 종료: " + socket);
        inputStream.close();
        outputStream.close();
        socket.close();

    }
}
