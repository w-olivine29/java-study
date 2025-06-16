package ch16access.pack1;


/*
클래스의 접근제어자는 public ,default 만 가능
하나의 .java 파일에 public 클래스는 단 하나
default 클래스는 개수제한 X
*/
public class PublicClass {
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();

        DefaultClass1 defaultClass1 = new DefaultClass1();
        DefaultClass2 defaultClass2 = new DefaultClass2();
        DefaultClass3 defaultClass3 = new DefaultClass3();
    }
}

class DefaultClass1 {

}

class DefaultClass2 {

}

class DefaultClass3 {

}
