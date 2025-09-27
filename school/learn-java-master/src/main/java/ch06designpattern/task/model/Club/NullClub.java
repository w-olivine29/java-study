package ch06designpattern.task.model.Club;

public class NullClub implements Club {

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getInfo() {
        return "가입 동아리 없음";
    }
}
