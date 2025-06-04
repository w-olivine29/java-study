package ch24nestedclasses.section1static.sub2example.step1before;

public class Network {

    public void sendMessage(String text) {
        NetworkMessage networkMessage= new NetworkMessage(text);
        networkMessage.print();
    }
}
