package optionaltask.task1;

// 41기 유도경
public class Person {

    // 값을 지정해준 필드
    @JsonField(value = "full_name")
    private String name;

    // 디폴트 값 필드
    @JsonField
    private int personAge;

    // 스킵 필드
    @JsonField(skipYn = true)
    private String gender;

    // 애노테이션 생략 필드 (스네이크로 변환하지 않음)
    private boolean isMarried;

    public Person(String name, int personAge, String gender, boolean isMarried) {
        this.name = name;
        this.personAge = personAge;
        this.gender = gender;
        this.isMarried = isMarried;
    }
}
