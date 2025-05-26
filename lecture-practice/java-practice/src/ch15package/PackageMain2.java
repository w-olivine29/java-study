package ch15package;

//import ch15package.pack1.Member1;
//import ch15package.pack1.Member2;

//pack1 패키지의 모든 클래스를 import [하위 패키지는 포함x (하위, 상위 상관없이 다른 패키지인 것)]
import ch15package.pack1.*;

public class PackageMain2 {
    public static void main(String[] args) {
        Data data = new Data(); // 같은 패키지의 경우 import x

        // import문 사용 시 패키지명 생략가능
        Member1 member1 = new Member1();
        Member2 member2 = new Member2();
    }
}
