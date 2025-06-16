package ch15package;

import ch15package.pack1.*;

public class PackageMain3 {
    public static void main(String[] args) {
        Data data = new Data();

        // 패키지가 다른 같은 이름의 클래스가 있다면, 적어도 한 패키지의 것은 직접 경로를 적어줘야한다.
        Member1 member1 = new Member1();
        Member2 member2 = new Member2();

        ch15package.pack2.Member1 member3 = new ch15package.pack2.Member1();
        ch15package.pack2.Member2 member4 = new ch15package.pack2.Member2();
    }
}
