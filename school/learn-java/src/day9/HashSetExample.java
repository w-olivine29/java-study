package day9;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        // 중복검사
        set.add("JAVA");
        set.add("C");
        System.out.println(set); //[JAVA]

        set.add("JAVA"); // 중복 데이터 추가 x
        System.out.println(set); //[JAVA]

        // 삭제
        set.remove("JAVA");
        System.out.println(set); //[C]


        // Hashcode 테스트 (equals는 재정의한 상태)
        Set<ElementNoOverrideHashCode<String>> hashCodeHashSet1 = new HashSet<>();
        hashCodeHashSet1.add(new ElementNoOverrideHashCode<>("JAVA"));

        // 논리적으로 같은 객체가 있는 검사 시도
        if (hashCodeHashSet1.contains(new ElementNoOverrideHashCode<>("JAVA"))) {
            System.out.println("해당 요소가 존재합니다.");
        } else {
            System.out.println("해당 요소가 없습니다.");
        }


        Set<Element<String>> hashCodeHashSet2 = new HashSet<>();
        hashCodeHashSet2.add(new Element<>("JAVA"));

        // 논리적으로 같은 객체가 있는 검사 시도
        if (hashCodeHashSet2.contains(new Element<>("JAVA"))) {
            System.out.println("해당 요소가 존재합니다.");
        } else {
            System.out.println("해당 요소가 없습니다.");
        }

    }
}

class ElementNoOverrideHashCode<E> {

    private E value;

    public ElementNoOverrideHashCode(E value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ElementNoOverrideHashCode<?> elementNoOverrideHashCode = (ElementNoOverrideHashCode<?>) o;
        return Objects.equals(value, elementNoOverrideHashCode.value);
    }
}

class Element<E> {

    private E value;

    public Element(E value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Element<?> element = (Element<?>) o;
        return Objects.equals(value, element.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}