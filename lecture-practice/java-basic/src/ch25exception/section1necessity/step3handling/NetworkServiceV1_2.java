package ch25exception.section1necessity.step3handling;


/* next step
   에러 발생 시 연결자원 해제가 안되는 상태
    -> 네트워크 자원이 계속 고갈될 수 있음 (자바 내부가 아닌 외부 연결 자원은 자동 해제 불가)

    외부 자원 사용 후엔 연결을 해제하여 외부자원을 반드시 반납해야함
* */
public class NetworkServiceV1_2 { // 복잡한 NetworkClient 사용 로직 처리


    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data);


        // 오류코드를 문자열로 반환중 -> 반환 값을 사용해서 예외 상황 처리
        String connectResult = client.connect();
        if (isError(connectResult)) {
            System.out.println("[network error] error code: " + connectResult);
            return;
        }

        String sendResult = client.send(data);
        if (isError(connectResult)) {
            System.out.println("[network error] error code: " + sendResult);
            return;
        }

        // 에러 발생 시 연결 자원 해제가 되지 않는 상태
        client.disconnect();
    }


    // 메서드 추출 후 isError 라고 네이밍한 이유
    // "결과가 성공이 아니다" vs "오류" -> "오류"가 명확하고 바로 인지하기에 좋음
    private static boolean isError(String connectResult) {
        return !connectResult.equals("success");
    }
}
