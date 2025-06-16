package ch21lang.section1obejct.sub5equals.step2;

import java.util.Objects;

public class User {
    private String id;

    public User(String id) {
        this.id = id;
    }

    // 인텔리제이 제공 equals
    // getClass() comparison expression
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }


    // 직접 재정의해본 equals
/*    @Override
    public boolean equals(Object o) {
        if (o instanceof User user) {
            return this.id.equals(user.id);
        } else {
            return false;
        }
    }
*/
}
