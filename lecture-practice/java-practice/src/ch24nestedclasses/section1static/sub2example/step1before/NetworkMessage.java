package ch24nestedclasses.section1static.sub2example.step1before;

// Network 객체에서만 사용할 예정
public class NetworkMessage {

    private String content;


    public NetworkMessage(String content) {
        this.content = content;
    }

    public void print() {
        System.out.println("content = " + content);
    }


   /*
    Network 클래스 내부에서만 쓰이는 NetworkMessage 클래스가 외부의 별개의 클래스로 존재 시
    처음 코드를 접할 때
    - 다른 여러곳에서도 사용이 되겠구나
    - NetworkMessage 클래스 생성자를 별도로 만든 다음 뭔가를 해야하나?
    라는 등의 불필요한 과정을 거치게 됨
    */
}
