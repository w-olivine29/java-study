package ch04network.sub4resourcedisposal.autocloseable;


// 가상의 시나리오
public class ResourceV2_AutoCloseable implements AutoCloseable {

    private String name;

    public ResourceV2_AutoCloseable(String name) {
        this.name = name;
    }

    // 정상로직
    public void call() {
        System.out.println(name + "call");
    }

    // 비정상 로직
    public void callEx() throws CallException {
        System.out.println(name + "callEx");
        throw new CallException(name + "ex");
    }


    @Override
    public void close() throws CloseException {
        System.out.println(name + "close");
        throw new CloseException(name + "ex");
        // AutoCloseable 로 자궝 정리할 때 예외 터지면?
    }
}
