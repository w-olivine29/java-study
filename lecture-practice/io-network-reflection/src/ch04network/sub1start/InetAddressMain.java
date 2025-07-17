package ch04network.sub1start;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {
    public static void main(String[] args) throws UnknownHostException {

        // 호스트이름으로 해당하는 IP주소 조회
        InetAddress localhost = InetAddress.getByName("localhost");
        System.out.println("localhost = " + localhost); //localhost/127.0.0.1

        InetAddress google = InetAddress.getByName("google.com");
        System.out.println("google = " + google); //실습 시점에는 google.com/142.250.206.206

        InetAddress naver = InetAddress.getByName("naver.com");
        System.out.println("naver = " + naver); //실습 시점에는 naver.com/223.130.192.247


    }
}
/* InetAddress 클래스
호스트이름으로 대상 IP 찾을 수 있음
 
 자바는 InetAddress.getByName("호스트 이름"); -> 해당하는 IP 주소 조회
    1. 시스템의 호스트 파일 먼저 확인 (운영체제 마다 찾는 위치 다름)
    2. 호스트 파일에 정의 돼있지 않으면 DNS 서버에 요청해서 IP주소를 얻어옴
 
*/