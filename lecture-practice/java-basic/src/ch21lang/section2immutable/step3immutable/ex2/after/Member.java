package ch21lang.section2immutable.step3immutable.ex2.after;

public class Member {

    private String name;
    private ImmutableAddress address;

    public Member(String name, ImmutableAddress address) {
        this.name = name;
        this.address = address;
    }

    public ImmutableAddress getAddress() {
        return address;
    }

    public void changeAddress(ImmutableAddress address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
