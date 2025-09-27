package ch06designpattern.task.dto;

import ch06designpattern.task.model.Club.Club;

public record CreateStudentRequest(
        Long id,
        String name,
        int grade,
        String department,
        Club club
) {

}
