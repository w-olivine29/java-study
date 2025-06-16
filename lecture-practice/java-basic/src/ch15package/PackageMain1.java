package ch15package;


public class PackageMain1 {
    public static void main(String[] args) {
        Data data = new Data(); // 같은 패키지의 경우 import x

        // 서로 다른 패키지의 경우 패키지 전체 경로를 포함하여 적어줘야한다 (하위 패키지도 다른 패키지)
        ch15package.pack1.Member1 member1 = new ch15package.pack1.Member1();
    }
}
