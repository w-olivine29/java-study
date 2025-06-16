package ch24nestedclasses.section1static.sub2example.step2after;

public class Network {

    public void sendMessage(String text) {

        // 나의 클래스에 포함한 중첩 클래스는 바로 접근 (바깥클래스.중첩클래스 형태로 접근 x)
        NetworkMessage networkMessage = new NetworkMessage(text);
        networkMessage.print();
    }

    // private static  -> Network 내부에서만 단독으로 사용하는 클래스라고 인지
    private static class NetworkMessage {
        private String content;

        public NetworkMessage(String content) {
            this.content = content;
        }

        public void print() {
            System.out.println("content = " + content);
        }
    }

}
