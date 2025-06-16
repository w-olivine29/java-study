package ch21lang.section2immutable.step3immutable.ex2.before;

public class Member {

    private String name;
    private Address address;

    public Member(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
