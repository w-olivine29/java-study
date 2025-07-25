package ch07annotation.step5validator.after;

import static ch07annotation.step5validator.after.Validator.validate;
import static utils.MyLogger.log;

public class ValidatorV2Main {
    public static void main(String[] args) {
        User user = new User("유저1", 0);
        Team team = new Team("", 0);

        try {
            log("== user 검증 ==");
            validate(user);
        } catch (Exception e) {
            log(e);
        }

        try {
            log("== team 검증 ==");
            validate(team);
        } catch (Exception e) {
            log(e);
        }
    }
}
