package ch07annotation.step5validator.before;

import ch07annotation.step5validator.after.Team;
import ch07annotation.step5validator.after.User;

import static utils.MyLogger.log;

public class ValidatorV1Main {
    public static void main(String[] args) {
        User user = new User("유저1", 0);
        Team team = new Team("", 0);

        try {
            log("== user 검증 ==");
            validateUser(user);
        } catch (Exception e) {
            log(e);
        }

        try {
            log("== team 검증 ==");
            validateTeam(team);
        } catch (Exception e) {
            log(e);
        }
    }

    private static void validateUser(User user) {
        if (user.getName() == null | user.getName().isEmpty()) {
            throw new RuntimeException("이름이 비었습니다.");
        }
        if (user.getAge() < 1 || user.getAge() > 100) {
            throw new RuntimeException("나이제한 1 ~ 100 ");
        }
    }

    private static void validateTeam(Team team) {
        if (team.getName() == null | team.getName().isEmpty()) {
            throw new RuntimeException("이름이 비었습니다.");
        }
        if (team.getMemberCount() < 1 || team.getMemberCount() > 999) {
            throw new RuntimeException("회원수 제한 1 ~ 999 ");
        }
    }
}
/*
값이 비었는지 여부와 숫자 범위 검증하는 부분
코드는 비슷한데 User, Team 이 완전히 다른 클래스이기때문에 재사용 불가 (필드이름, 오류메세지, 검증 값 범위 등 상이)

-> 다른 객체들도 검증 시 비슷한 검증 기능을 계속 추가해야하는 상황

next step)
    애노테이션 활용하여 검증기능을 만들어보자
*/