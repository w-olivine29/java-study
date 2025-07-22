package ch05chatprogram.client;

import java.io.DataInputStream;
import java.io.IOException;

import static utils.MyLogger.log;

public class ReadHandler implements Runnable {

    private final DataInputStream inputStream;
    private final Client client;
    private boolean closed; // 중복 종료를 막기위한 flag

    public ReadHandler(DataInputStream inputStream, Client client) {
        this.inputStream = inputStream;
        this.client = client;
    }

    // 서버의 메세지를 반복해서 수신 & 콘솔에 출력
    @Override
    public void run() {

        try{
            while (true) {
                String received = inputStream.readUTF();
                System.out.println(received);
            }
        }catch (IOException e){
            log(e);
        }finally {
            client.close(); // 전체 자원 정리
        }
    }

    // 나 자신 닫기
    // 다른 이유로도 호출 되는 상황이 있기때문에 동기화 처리
    public synchronized void close(){
        
        // close 가 두번 호출 되지 않도록 flag 조건문
        if(closed){
            return;
        }

        // 복잡한 종료 로직이 있다고 가정?
        closed = true;
        log("readHandler 종료");
    }
}
