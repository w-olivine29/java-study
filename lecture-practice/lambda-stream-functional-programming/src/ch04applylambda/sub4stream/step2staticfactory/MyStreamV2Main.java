package ch04applylambda.sub4stream.step2staticfactory;

import java.util.List;

public class MyStreamV2Main {
    public static void main(String[] args) {
        // 짝수만 남기고 남은 값의 2배 반환

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result = MyStreamV2.of(numbers)
                .filter(num -> num % 2 == 0)
                .map(num -> num * 2)
                .toList();
        System.out.println("result = " + result);
    }
}

/* 정적 팩토리 메서드
객체 생성을 담당하는 정적 메서드로써, 생성자 대신 인스턴스를 생성하고 반환하는 역할
일반적인 생성자 대신에 클래스의 인스턴스 생성 & 초기화 로직을 캡슐화하여 제공

- 정적 메서드: 클래스 레벨 호출, 인스턴스 생성 없이 접근 가능

- 객체 반환: 내부에서 생성한 객체(또는 이미 존재하는 객체)를 반환
- 유연한 구현: 객체 생성 과정에서 캐싱, 객체 재활용, 하위 타입 객체 반환 등 다양한 로직 적용가능
    ex) Integer.valueOf(): -128 ~ 127 범위는 내부에 가지고 있는 Integer 객체 반환
    
- 생성자 대체: 생성자와 달리 메서드 이름 명시 가능 (생성 과정의 목적이나 특징을 명확하게 표현 가능)


생성자는 이름부여 불가하지만, 
정적팩토리 메서드는 의미가 있는 이름 부여 가능 -> 가독성이 더 좋아짐

인자들을 받아 간단하게 객체를 생성할 때는 주로 of() 라는 이름 사용
*/