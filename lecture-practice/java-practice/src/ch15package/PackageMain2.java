package ch15package;

//import ch15package.pack1.Member1;
//import ch15package.pack1.Member2;
import ch15package.pack1.*; //pack1 패키지의 내의 모든 것을 import

public class PackageMain2 {
    public static void main(String[] args) {
        Data data = new Data(); // 같은 패키지의 경우 import x

        // import문 사용 시 패키지명 생략가능
        Member1 member1 = new Member1();
        Member2 member2 = new Member2();
    }
}
