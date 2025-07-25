package ch07annotation.step5validator.after;

public class Team {

    @NotEmpty(message = "팀 이름이 비었습니다.")
    private String name;

    @Range(min=1, max = 999, message = "팀 회원수 제한 1 ~ 999")
    private int memberCount;

    public Team(String name, int memberCount) {
        this.name = name;
        this.memberCount = memberCount;
    }

    public String getName() {
        return name;
    }

    public int getMemberCount() {
        return memberCount;
    }
}
