package ch27collection.section5hashset.hashcode.step2java;

import java.util.Objects;

public class JavaHashCodeMain {
    public static void main(String[] args) {

        //Object의 기본 hashCode는 객체의 참조값을 기반으로 생성
        Object obj1 = new Object();
        Object obj2 = new Object();

        System.out.println("obj1.hashCode() = " + obj1.hashCode()); //189568618
        System.out.println(System.identityHashCode(obj1)); //189568618
        System.out.println("obj1 = " + obj1); //java.lang.Object@b4c966a (위의 해시코드가 16진수화된 것)

        System.out.println("obj2.hashCode() = " + obj2.hashCode()); //664223387
        System.out.println(System.identityHashCode(obj1)); //664223387
        System.out.println("obj2 = " + obj2); //java.lang.Object@27973e9b (위의 해시코드가 16진수화된 것)


// =====================================================

        // String, Wrapper 등의 기본제공 클래스들은 hashCode가 오버라이딩 돼있음
        Integer num1 = 10;
        Integer num2 = new Integer(10); // Integer.valueOf()로 생성하면 캐싱된 객체를 반환하기때문에 new 연산자 사용

        String str1 = "A";
        String str2 = new String("A"); // 문자열 풀에서 같은 객체를 반환받지 않기 위해 new 연산자 사용

        // num1 과 num2의 참조값이 다르지만, hashCode()의 결과값은 같음을 볼 수 있음
        System.out.println("System.identityHashCode(num1) = " + System.identityHashCode(num1)); //824909230
        System.out.println("num1.hashCode() = " + num1.hashCode()); //10

        System.out.println("System.identityHashCode(num2) = " + System.identityHashCode(num2)); //122883338
        System.out.println("num2.hashCode() = " + num2.hashCode() + "\n"); //10


        // str1 과 str2의 참조값이 다르지만, hashCode()의 결과값는 같음을 볼 수 있음
        System.out.println("System.identityHashCode(str1) = " + System.identityHashCode(str1)); //960604060
        System.out.println("str1.hashCode() = " + str1.hashCode()); //65

        System.out.println("System.identityHashCode(str2) = " + System.identityHashCode(str2)); //1349393271
        System.out.println("str2.hashCode() = " + str2.hashCode()); //65

// =====================================================
        //-10 (해시코드는 음수값도 있다.)
        System.out.println("Integer -10.hashCode(): " + Integer.valueOf(-10).hashCode());

// =====================================================

        // equals 재정의 (id 값이 동일 시 동일한 값으로 간주)
        Member member1 = new Member("ID-001");
        Member member2 = new Member("ID-001");

        System.out.println("member1 == member2 = " + (member1 == member2)); //false  (참조값 비교)

        System.out.println("member1.equals(member2) = " + member1.equals(member2));  //true

        System.out.println("Objects.equals(member1,member2) = " + Objects.equals(member1, member2)); //true
        // Objects.equals(Object a, Object b) => 내부에서 a.equals(b) 호출


        // 오버라이딩 전에 나왔을 hashCode()의 결과
        System.out.println("System.identityHashCode(member1) = " + System.identityHashCode(member1)); //1349393271
        System.out.println("System.identityHashCode(member2) = " + System.identityHashCode(member2)); //1338668845

        // 오버라이딩 후의 해시코드
        System.out.println("member1.hashCode(): " + member1.hashCode()); //-2140851585
        System.out.println("member2.hashCode(): " + member2.hashCode()); //-2140851585

    }
}
