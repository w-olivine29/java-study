package ch06reflection.step3field;

import ch06reflection.data.User;

import java.lang.reflect.Field;

public class FieldV2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User user = new User("id1", "유저1", 20);
        System.out.println("기존 이름: " + user.getName());

        Class<? extends User> aClass = User.class;
        Field nameField = aClass.getDeclaredField("name");

        // setAccessible(true) -> private 필드에 접근가능 (메서드도 가능)
        nameField.setAccessible(true); // 해당 설정이 없다면 아래 주석처럼 예외발생
        nameField.set(user, "user1"); //IllegalAccessException: class ch06reflection.step4field.FieldV2 cannot access a member of class ch06reflection.data.User with modifiers "private"
        System.out.println("변경된 이름 = " + user.getName());
    }
}

/*
- 클래스 내부 구조나 구현 세부 사항이 변경될 경우 리플렉션을 사용한 코드는 쉽게 깨질 수 있으며 버그 초래 가능
- 리플렉션 사용 시엔 반드시 신중하게 접근
- 가능하면 접근 메서드를 사용 (getter, setter)
- 일반적인 애플리케이션 코드에는 권장 x (무분별하게 사용 시 가독성, 안정성 저하)
*/