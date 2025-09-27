package ch06designpattern.task.model.student;

import ch06designpattern.task.model.Club.Club;

public interface Student {

    long getId();
    String getName();
    String department();
    Club getClub();

    String getInfo();
}
