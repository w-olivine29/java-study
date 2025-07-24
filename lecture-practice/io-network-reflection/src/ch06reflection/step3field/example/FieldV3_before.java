package ch06reflection.step3field.example;

import ch06reflection.data.Team;
import ch06reflection.data.User;

/*
데이터 저장 시에 반드시 null을 사용하면 안된다고 가정
null일 경우 다른 기본 값으로 모두 변경하기
*/
public class FieldV3_before {
    public static void main(String[] args) {
        User user = new User("id1", null, null);
        Team team = new Team("team1", null);

        System.out.println("===== before =====");
        System.out.println("user = " + user);
        System.out.println("team = " + team);

        if (user.getId() == null) {
            user.setId("");
        }
        if (user.getName() == null) {
            user.setName("");
        }
        if (user.getAge() == null) {
            user.setAge(0);
        }
        if (team.getId() == null) {
            team.setId("");
        }
        if (team.getName() == null) {
            team.setName("");
        }
        
        // 해당 문제 해결 시 객체의 모든 데이터다 찾아서 입력해야하는 상황

        System.out.println("===== after =====");
        System.out.println("user = " + user);
        System.out.println("team = " + team);
    }
}
