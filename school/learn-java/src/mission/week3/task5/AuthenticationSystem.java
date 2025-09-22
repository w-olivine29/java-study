package mission.week3.task5;


import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 41기 유도경
public class AuthenticationSystem {

    public static void main(String[] args) {
        
        // 로그인 요청 대기 유저목록 가정
        List<User> users = List.of(
                new User("사용자 A"),
                new User("사용자 B"),
                new User("사용자 C"),
                new User("사용자 D"),
                new User("사용자 E"),
                new User("사용자 F")
        );

        AuthenticationSystem system = new AuthenticationSystem(Executors.newCachedThreadPool());
        system.execute(users);

    }

    private final ExecutorService es;

    public AuthenticationSystem(ExecutorService es) {
        this.es = es;
    }

    public void execute(List<User> users) {

        try (es) {
            for (User user : users) {
                es.execute(() -> {
                    login(user);
                    UserContext.clear();
                });
            }
        }
    }
    private void login(User user) {
        UserContext.setUser(user);
        printLoginInfo();
    }

    private void printLoginInfo() {
        System.out.printf("[%s] 로그인: %s\n",
                Thread.currentThread().getName(),
                UserContext.getUser().getName());
    }

}
