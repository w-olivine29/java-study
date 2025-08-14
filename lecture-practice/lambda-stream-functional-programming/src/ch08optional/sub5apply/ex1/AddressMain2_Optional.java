package ch08optional.sub5apply.ex1;

import ch08optional.sub5apply.ex1.model.Address;
import ch08optional.sub5apply.ex1.model.User;

public class AddressMain2_Optional {
    public static void main(String[] args) {
        User user1 = new User("user", null);
        User user2 = new User("user", new Address("street"));
    }

    private static void printStreet(User user){
        String userStreet = getUserStreet(user);
        if (userStreet != null) {
            System.out.println("userStreet = " + userStreet);
        }else {
            System.out.println("userStreet = " + "UNKNOWN");
        }
    }

    static String getUserStreet(User user) {
        if (user == null) {
            return null;
        }
        Address address = user.getAddress();
        if (address == null) {
            return null;
        }
        return address.getStreet();
    }
}

/*
 null 체크가 여러 번 등장
 점점 내부 구조가 복잡해지면 null 체크 구문이 계속 늘어날 것임
*/