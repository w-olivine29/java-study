package ch25exception.section1necessity.step3handling;


/* next step

정상흐름과 예외 흐름이 분리돼있지 않아서, 정상흐름을 바로 인지하기가 힘든 상태  -> 흐름의 분리가 필요
이런문제의 경우 반환 값을 이용해서 예외상황을 처리하는 방식으로는 해결불가

-> 자바의 예외 처리 매커니즘 적용
* */
public class NetworkServiceV1_3 { // 복잡한 NetworkClient 사용 로직 처리


    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data);



        // 정상흐름과 예외 흐름이 분리돼있지 않아서, 정상흐름을 바로 인지하기가 힘든 상태
        String connectResult = client.connect();
        if (isError(connectResult)) {
            System.out.println("[network error] error code: " + connectResult);
        } else {
            String sendResult = client.send(data);
            if (isError(connectResult)) {
                System.out.println("[network error] error code: " + sendResult);
            }
        }

        // 에러가 발생여부와는 상관없이 disconnect
        client.disconnect();
    }


    // 메서드 추출 후 isError 라고 네이밍한 이유
    // "결과가 성공이 아니다" vs "오류" -> "오류"가 명확하고 바로 인지하기에 좋음
    private static boolean isError(String connectResult) {
        return !connectResult.equals("success");
    }
}
