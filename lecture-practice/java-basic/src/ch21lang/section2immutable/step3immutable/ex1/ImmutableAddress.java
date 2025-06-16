package ch21lang.section2immutable.step3immutable.ex1;

// 생성자를 통해서만 값 설정 가능
public class ImmutableAddress {

    private final String addressName;

    public ImmutableAddress(String value) {
        this.addressName = value;
    }

    public String getValue() {
        return addressName;
    }


    public ImmutableAddress changeAddress(String addressName) {
        return new ImmutableAddress(addressName);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressName='" + addressName + '\'' +
                '}';
    }
}
