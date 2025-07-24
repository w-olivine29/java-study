package ch06reflection.step3field.example;

import ch06reflection.data.FieldUtil;
import ch06reflection.data.Team;
import ch06reflection.data.User;

/*
데이터 저장 시에 반드시 null을 사용하면 안된다고 가정
null일 경우 다른 기본 값으로 모두 변경하기
*/
public class FieldV4_after {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("id1", null, null);
        Team team = new Team("team1", null);

        System.out.println("===== before =====");
        System.out.println("user = " + user);
        System.out.println("team = " + team);

        // 리플렉션을 활용함으로써 편리하게 기본 값을 적용하게 되었음
        // 해당 객체 뿐만 아니라 수 많은 객체에 적용 가능
        FieldUtil.nullFieldToDefault(user);
        FieldUtil.nullFieldToDefault(team);

        System.out.println("===== after =====");
        System.out.println("user = " + user);
        System.out.println("team = " + team);
    }
}
