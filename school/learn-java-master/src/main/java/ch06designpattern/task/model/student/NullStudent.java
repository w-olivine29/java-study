package ch06designpattern.task.model.student;

import ch06designpattern.task.model.Club.Club;
import ch06designpattern.task.model.Club.NullClub;

public class NullStudent implements Student {

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String department() {
        return "";
    }

    @Override
    public Club getClub() {
        return new NullClub();
    }

    @Override
    public String getInfo() {
        return "존재하지 않는 학생입니다.";
    }
}
