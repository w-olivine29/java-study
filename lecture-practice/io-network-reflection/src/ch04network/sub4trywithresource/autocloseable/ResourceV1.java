package ch04network.sub4trywithresource.autocloseable;


// 가상의 시나리오
public class ResourceV1 {

    private String name;

    public ResourceV1(String name) {
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

    // 정상 종료
    public void close() {
        System.out.println(name + "close");
    }

    // 비정상 종료
    public void closeEx() throws CloseException {
        System.out.println(name + "closeEx");
        throw new CloseException(name + " ex");
    }
}
