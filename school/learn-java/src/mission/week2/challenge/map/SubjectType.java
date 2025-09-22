package mission.week2.challenge.map;


// 41기 유도경
public enum SubjectType {
    KOREAN("국어"),
    MATH("수학"),
    ENGLISH("영어"),
    SCIENCE("과학"),
    HISTORY("역사")
    ;

    public final String subjectName;

    SubjectType(String subjectName) {
        this.subjectName = subjectName;
    }
}
