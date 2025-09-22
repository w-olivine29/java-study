package mission.week3.task5;

// 41기 유도경
public class UserContext {

    private static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public static User getUser() {
        return userThreadLocal.get();
    }

    public static void setUser(User user) {
        userThreadLocal.set(user);
    }

    public static void clear() {
        userThreadLocal.remove();
    }
}
