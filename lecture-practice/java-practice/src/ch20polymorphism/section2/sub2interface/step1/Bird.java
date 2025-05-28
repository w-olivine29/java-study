package ch20polymorphism.section2.sub2interface.step1;

// 인터페이스는 구현 메서드 허용x
public interface Bird {

    // 필드를 넣었다면 public static final 로 간주

    // 키워드 생략 시 public abstract 로 간주
    void sound();

    void fly();

    // 예외적인 상황에서 default, private 사용 가능 (현재 챕터에서는 제외)
}


